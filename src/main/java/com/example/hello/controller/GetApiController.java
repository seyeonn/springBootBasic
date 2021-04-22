package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    //path라는 속성을 사용하여 GetMapping에 명확하게 경로 지
    @GetMapping(path = "/hello")
    public String getHello() {
        return "get Hello!";
    }

    //get, post, put, delete 모두 가능
    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi() {
        return "hi";
    }

    // http://localhost:8088/api/get/path-variable/{name}
    //GetMapping {} 안에 들은 내용과 PathVariable의 내용이 일치 해야한다. 변수 이름이 달라야 할 때는 속성 name으로 지정해준다.
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName) {
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    //search?q = intellij
    // &rlz = 1C5CHFA_enKR946KR946
    // &oq = intellij
    // &aqs = chrome..69i57j0l4j69i60j69i61l2.3850j0j7
    // &sourceid = chrome
    // &ie = UTF-8

    // ? 여기서부터 쿼리 파라미터. 쿼리 파라미터는 검색을 할 때 여러가지 매개변수의 인자를 말한다.
    // ?key=value&key2=value2 형태로 이루어져 있음.

    //http://localhost:8088/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {   //Map으로 받는 경우 key를 알 수 없다.

        StringBuilder sb= new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParma02 (
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age

    ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }

    /* 객체가 들어오게 되면 queryParameter에 들어있는 주소들(?이후)을 spring boot에서 판단을 한다.
       key에 해당하는 이름들을 해당 객체에서 변수의 이름과 매칭해주게 된다.
       미리 queryParameter에 대해서 정의를 해 놓은 경우 이런 식으로 객체를 만들어 사용하는 것이 편리하다.
    */
    //?user=steve&email=steve@gmail.com&age=30
    @GetMapping("query-param03")
    public String queryParam03 (UserRequest userRequest) {

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
