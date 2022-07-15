package com.example.controller;

/*
    @author syrio
    @date 2022/6/1
    @time 20:12
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/testParam")
    public String testParam() {
        return "test_param";
    }

}
