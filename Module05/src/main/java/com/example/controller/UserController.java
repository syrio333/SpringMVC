package com.example.controller;

/*
    @author syrio
    @date 2022/6/12
    @time 19:32
    @description 用户控制器 测试RESTFul
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    /*  /user       GET     查询所有用户
     *   /user/{id}  GET     根据id查询用户
     *   /user       POST    添加用户
     *   /user       PUT     修改用户
     *   /user/{id}  DELETE  根据id删除用户*/

    /*查询所有用户*/
    @GetMapping("/user")
    public ModelAndView getAllUser() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("result", "查询所有用户");
        mav.setViewName("success");
        return mav;
    }

    /*根据id查询用户*/
    @GetMapping("/user/{id}")
    public ModelAndView getUserById(@PathVariable("id") Integer id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("result", "根据id查询用户，id=" + id);
        mav.setViewName("success");
        return mav;
    }

    /*添加用户*/
    @PostMapping("/user")
    public ModelAndView postUser(String username, String password) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("result", "添加用户：username=" + username + "，password=" + password);
        mav.setViewName("success");
        return mav;
    }

    /*修改用户*/
    @PutMapping("/user")
    public ModelAndView putUser(String username, String password) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("result", "修改用户：username=" + username + "，password=" + password);
        mav.setViewName("success");
        return mav;
    }

}
