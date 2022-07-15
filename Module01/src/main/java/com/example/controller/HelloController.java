package com.example.controller;

/*
    @author syrio
    @date 2022/6/1
    @time 18:01
    Hello控制器
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String index() {
        /*返回视图名称*/
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }

}
