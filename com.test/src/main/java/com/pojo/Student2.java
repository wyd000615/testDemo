package com.pojo;

public class Student2 {
    private String name;
    private String na;

    public Student2(String name, String na) {
        this.name = name;
        switch (na) {
            case "1":
                this.na = "正常";
                break;
            case "4":
                this.na = "异常";
                break;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNa() {
        return na;
    }

    public void setNa(String na) {
        this.na = na;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", na='" + na + '\'' +
                '}';
    }
}
