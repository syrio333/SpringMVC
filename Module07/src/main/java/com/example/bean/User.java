package com.example.bean;

/*
    @author syrio
    @date 2022/6/16
    @time 12:02
    @description User类
*/

public class User {

    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String gender;

    public User() {
    }

    public User(Integer id, String name, String password, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
