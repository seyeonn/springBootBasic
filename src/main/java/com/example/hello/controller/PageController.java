package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//html page resource를 찾는 어노테이
@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";     // 리소스를 찾음
    }

    //ResponseEntity

    @ResponseBody               // 객체 자체를 리턴했을 때 리소스를 찾지 않고 responseBody를 만들어서 보낸다.
    @GetMapping("/user")
    public User user() {
        var user = new User();
        user.setName("steve");
        user.setAddress("패스트 캠퍼스");
        return user;
    }

}
