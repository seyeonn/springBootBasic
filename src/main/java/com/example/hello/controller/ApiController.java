package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController               //해당 Class는 REST API를 처리하는 Controller
@RequestMapping("/api")    //RequestMapping URI 를 지정해주는 Annotation
public class ApiController {

    //default로 지정해줄 경우, value 값으로 지정되면서 path로 동작하게 된다.
    @GetMapping("/hello")    // http://localhost:8088/api/hello
    public String hello() {
        return "hello spring boot!";
    }

    // TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    // JSON
    // request -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json (@RequestBody User user) {
        return user;   //200 Ok
    }

    // ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
