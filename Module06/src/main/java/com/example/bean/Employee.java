package com.example.bean;

/*
    @author syrio
    @date 2022/6/13
    @time 17:24
    @description 员工实体类
*/

public class Employee {

    private Integer id;
    private String name;
    /*0为女，1为男*/
    private Integer gender;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee() {
    }

    public Employee(Integer id, String name, Integer gender, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
    }
}
