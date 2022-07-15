package com.example.controller;

/*
    @author syrio
    @date 2022/6/12
    @time 17:02
    @description
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/success")
    public String success() {
        return "success";
    }

}
