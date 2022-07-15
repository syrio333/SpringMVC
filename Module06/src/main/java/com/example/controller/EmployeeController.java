package com.example.controller;

/*
    @author syrio
    @date 2022/6/13
    @time 17:36
    @description 员工 控制层
*/

import com.example.bean.Employee;
import com.example.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class EmployeeController {

    /*/employee         GET     查询所有员工
     * /employee/{id}    GET     根据id查询员工
     * /employee         PUT     修改员工
     * /employee_add     GET     跳转至添加员工页面
     * /employee         POST    添加员工
     * /employee/{id}    DELETE  根据id删除员工*/

    @Autowired
    private EmployeeDao employeeDao;

    /*查询所有员工*/
    @GetMapping("/employee")
    public ModelAndView getAllEmployee() {
        ModelAndView mav = new ModelAndView();
        Collection<Employee> employees = employeeDao.getAll();
        mav.addObject("employees", employees);
        mav.setViewName("all_employee");
        return mav;
    }

    /*根据id查询员工*/
    @GetMapping("/employee/{id}")
    public ModelAndView getEmployeeById(@PathVariable("id") Integer id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("employee", employeeDao.getById(id));
        mav.setViewName("employee_update");
        return mav;
    }

    /*更新员工信息*/
    @PutMapping("/employee")
    public String putEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    /*添加员工*/
    @PostMapping("/employee")
    public String postEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    /*根据id删除员工*/
    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") Integer id) {
        employeeDao.deleteById(id);
        return "redirect:/employee";
    }

}
