package com.imooc.domain;

/**
 * Student实体类
 */
public class Student {

    private int id ;      //主键字段
    private String name;  //姓名
    private int age;      //年龄

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
