package com.example.hello;

import com.example.hello.dto.User02;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("--------------");

        // Text JSON -> Object
        // Object -> Text JSON

        // controller req json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();

        // object -> text
        // object mapper get method 를 활용한다.

        var user02 = new User02("steve", 10, "010-1111-2222");
        var text = objectMapper.writeValueAsString(user02);
        System.out.println(text);

        // text -> object
        // object mapper는 동작하기 위해서 default 생성자가 있어야 한다.
        var objectUser = objectMapper.readValue(text, User02.class);
        System.out.println(objectUser);
    }

}
