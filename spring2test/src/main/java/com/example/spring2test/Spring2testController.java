package com.example.spring2test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Spring2testController {
    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "name") String name){
        return "Hello, " + name + "!";
    }
}
