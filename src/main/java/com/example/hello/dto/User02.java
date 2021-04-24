package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User02 {
    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

    public User02() {
        this.name = null;
        this.age = 0;
        this.phoneNumber = null;
    }

    public User02(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public User02 defaultUser() {
        return new User02("default",0, "010-1111-2222");
    }

    @Override
    public String toString() {
        return "User02{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
