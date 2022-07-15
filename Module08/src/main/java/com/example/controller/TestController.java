package com.example.controller;

/*
    @author syrio
    @date 2022/6/18
    @time 15:52
    @description
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    /*测试拦截器*/
    @GetMapping("/testInterceptor")
    public ModelAndView testInterceptor(ModelAndView mav) {
        System.out.println("testInterceptor");
        mav.setViewName("success");
        return mav;
    }

    /*测试异常处理器*/
    @GetMapping("/testExceptionHandler")
    public ModelAndView testExceptionHandler(ModelAndView mav) {
        System.out.println(3 / 0);
        mav.addObject("result", "测试异常处理器");
        mav.setViewName("success");
        return mav;
    }

}
