package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController               //해당 Class는 REST API를 처리하는 Controller
@RequestMapping("/api")    //RequestMapping URI 를 지정해주는 Annotation
public class ApiController {

    //default로 지정해줄 경우, value 값으로 지정되면서 path로 동작하게 된다.
    @GetMapping("/hello")    // http://localhost:8088/api/hello
    public String hello() {
        return "hello spring boot!";
    }
}
