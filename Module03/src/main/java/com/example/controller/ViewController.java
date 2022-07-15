package com.example.controller;

/*
    @author syrio
    @date 2022/6/8
    @time 20:49
    @description 测试 视图
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    /*转发：浏览器发送一次请求，服务器内部发送一次请求，第二次请求无法跨域*/
    /*重定向：浏览器发送两次请求，第二次请求可以跨域*/

    /*测试以 forward: 开头的视图名称创建InternalResourceView转发视图*/
    @RequestMapping("/testInternalResourceView")
    public String testInternalResourceView() {
        /*第一次创建的是InternalResourceView转发视图*/
        /*转发到/testRequestByServlet后创建的是原来的ThymeleafView*/
        return "forward:/testRequestByServletAPI";
    }

    /*测试以 redirect: 开头的视图名称创建RedirectView重定向视图*/
    @RequestMapping("/testRedirectView")
    public String testRedirectView() {
        /*第一次创建的是RedirectView重定向视图*/
        /*重定向到/testRequestByServlet后创建的是原来的ThymeleafView*/
        return "redirect:/testRequestByServletAPI";
    }

}
