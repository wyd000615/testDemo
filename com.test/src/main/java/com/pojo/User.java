package com.pojo;

public class User {
    private  String name;
    private String age;
    private String code;

    public User(String name, String age, String code) {
        this.name = name;
        this.age = age;
        this.code = code;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
