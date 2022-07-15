package com.example.controller;

/*
    @author syrio
    @date 2022/6/15
    @time 19:29
    @description 控制器 测试报文信息转换器
*/

import com.example.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HttpMessageConverterController {

    /*测试@RequestBody获取请求报文中的请求体*/
    @PostMapping("/testRequestBody")
    public ModelAndView testRequestBody(ModelAndView mav, @RequestBody String requestBody) {
        mav.addObject("result", requestBody);
        mav.setViewName("success");
        return mav;
    }

    /*测试RequestEntity获取整个请求报文*/
    @PostMapping("/testRequestEntity")
    public ModelAndView testRequestEntity(ModelAndView mav, RequestEntity<String> requestEntity) {
        mav.addObject("result", "请求头： " + requestEntity.getHeaders() + " 请求体： " + requestEntity.getBody());
        System.out.println(requestEntity.getBody());
        mav.setViewName("success");
        return mav;
    }

    /*测试通过ServletAPI的Response来响应浏览器数据（只有数据）*/
    @GetMapping("/testResponse")
    public void testResponse(HttpServletResponse response) {
        try {
            response.getWriter().print("testResponse");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    /*通过@ResponseBody来响应浏览器数据*/
    @GetMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "success";
    }

    /*通过@ResponseBody来直接返回Java对象*/
    @GetMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser() {
        return new User(1001, "张三", "123456", 23, "男");
    }

    /*测试Ajax发送请求*/
    @PostMapping("/testAxios")
    @ResponseBody
    public String testAxios() {
        return "testAxios";
    }

}
