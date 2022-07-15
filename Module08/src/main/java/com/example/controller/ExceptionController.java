package com.example.controller;

/*
    @author syrio
    @date 2022/7/8
    @time 14:56
    @description 异常处理器
*/

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView testExceptionHandlerByAnnotation(Exception exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", exception);
        mav.setViewName("error");
        return mav;
    }

}
