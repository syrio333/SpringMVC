package com.example.controller;

/*
    @author syrio
    @date 2022/6/2
    @time 0:08
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/requestMapping")
public class RequestMappingController {

    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }

    /*value属性是一个字符串数组*/
    @RequestMapping(value = {"/test", "test1"}, method = RequestMethod.GET)
    public String requestMappingTest() {
        return "success";
    }

    //    @GetMapping("/getMappingTest")
    @PostMapping("/getMappingTest")
    public String getMappingTest() {
        return "success";
    }

    @PutMapping("putMappingTest")
    public String putMappingTest() {
        return "success";
    }

    /*测试requestMapping的params和headers属性*/
    @RequestMapping(
            value = "/testParams",
            params = {"username=admin", "password"},
            headers = {"Host=localhost:8080"}
    )
    public String testParams() {
        return "success";
    }

    /*测试requestMapping支持ant风格的路径*/
//    @RequestMapping("/a?b/testAnt")
//    @RequestMapping("/a*b/testAnt")
//    @RequestMapping("/**/testAnt")
    @RequestMapping("/a**b/testAnt")
    public String testAnt() {
        return "success";
    }

    /*测试requestMapping支持占位符*/
    @RequestMapping("/testPlaceHolder/{username}/{password}")
    public String testPlaceHolder(@PathVariable("username") String username, @PathVariable("password") String password) {
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

}
