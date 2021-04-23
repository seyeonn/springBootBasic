package com.example.hello.controller;

import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    //get방식일 때는 @RequestParam, post방식일 때는 @RequestBody을 사용하여 Json 데이터로 파싱한다.
    @PostMapping("/post")
    public void post(@RequestBody PostRequestDto requestData) {
        System.out.println(requestData);
    }
}
