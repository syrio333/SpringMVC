package com.example.controller;

/*
    @author syrio
    @date 2022/6/2
    @time 16:49
    @description 测试获取请求参数
*/

import com.example.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
@RequestMapping("/testParam")
public class ParamController {

    /*通过servletAPI来获取参数*/
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {/*request由dispatcherServlet自动注入，表示当前请求*/
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "\n" + password);
        return "success";
    }

    /*通过在控制器方法中设置与参数同名的形参直接获取*/
    /*若参数中含多个同名参数可用字符串数组String[]接收或直接用字符串String*/
    @RequestMapping("/test")
    public String test(String username, String password, String[] hobby) {
        System.out.println("username:" + username + "\npassword:" + password + "\nhobby:" + Arrays.toString(hobby));
        return "success";
    }

    /*通过@RequestParam来处理请求参数与控制器方法参数的映射关系*/
    @RequestMapping("/testRequestParam")
    public String testRequestParam(
            @RequestParam("user_name") String username,
            @RequestParam(value = "pass_word", defaultValue = "123") String password,
            @RequestParam(value = "hobbies", required = false, defaultValue = "sleep") String[] hobby
    ) {
        System.out.println("username:" + username + "\npassword:" + password + "\nhobby:" + Arrays.toString(hobby));
        return "success";
    }

    /*通过@RequestHeader来获取请求头部*/
    /*请求头部的映射只能通过此方法，没有像请求参数的默认映射一样的方法*/
    /*三个属性value、required、defaultValue用法与@RequestParam完全相同*/
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(
            @RequestHeader(value = "Host", defaultValue = "testRequestHeader") String host
    ) {
        System.out.println(host);
        return "success";
    }

    /*通过@CookieValue来获取Cookie*/
    /*获取Cookie的映射只能通过此方法，没有像请求参数的默认映射一样的方法*/
    /*三个属性value、required、defaultValue用法与@RequestParam完全相同*/
    @RequestMapping("/testCookieValue")
    public String testCookieValue(
            HttpServletRequest request,
            @CookieValue(value = "JSESSIONID", required = false) String cookie
    ) {
        /*初始时无Cookie，执行了一次getSession后才有，第二次执行时可正确获取Cookie*/
        HttpSession session = request.getSession();
        System.out.println("cookie:" + cookie);
        return "success";
    }

    /*通过实体类来获取请求参数*/
    @RequestMapping("/testBean")
    public String testBean(User user) {
        System.out.println(user);
        return "success";
    }

}
