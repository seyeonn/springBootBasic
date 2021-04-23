package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account) {
        System.out.println(userId);
        System.out.println(account);

        // delete -> 리소스 삭제
        // 이미 리소스가 없더라도 에러가 발생하지 않고 200 ok
    }
}
