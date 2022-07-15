package com.example.controller;

/*
    @author syrio
    @date 2022/6/8
    @time 12:45
    @description 测试向域对象中共享数据
*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    /*向request域对象中共享数据*/
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request) {
        request.setAttribute("testRequestBy", "servletAPI");
        return "success";
    }

    /*向request域对象中共享数据*/
    @RequestMapping("/testRequestByModelAndView")
    public ModelAndView testRequestByModelAndView() {
        ModelAndView mav = new ModelAndView();
        /*处理模型数据，将数据分享给域对象*/
        mav.addObject("testRequestBy", "ModelAndView");
        /*设置视图名称*/
        mav.setViewName("success");
        return mav;
    }

    /*向request域对象中共享数据*/
    @RequestMapping("/testRequestByModel")
    public String testRequestByModel(Model model) {
        model.addAttribute("testRequestBy", "Model");
        /*Model,Map,ModelMap的关系*/
        System.out.println(model.getClass().getName());
        return "success";
    }

    /*向request域对象中共享数据*/
    @RequestMapping("/testRequestByMap")
    public String testRequestByMap(Map<String, Object> map) {
        map.put("testRequestBy", "Map");
        /*Model,Map,ModelMap的关系*/
        System.out.println(map.getClass().getName());
        return "success";
    }

    /*向request域对象中共享数据*/
    @RequestMapping("/testRequestByModelMap")
    public String testRequestByModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestBy", "ModelMap");
        /*Model,Map,ModelMap的关系*/
        System.out.println(modelMap.getClass().getName());
        return "success";
    }

    /*向session域对象中共享数据*/
    @RequestMapping("/testSessionByServletAPI")
    public String testSessionByServletAPI(HttpSession session) {
        session.setAttribute("testSessionBy", "servletAPI");
        return "success";
    }

    /*向application域对象中共享数据*/
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplication", "application");
        return "success";
    }

}
