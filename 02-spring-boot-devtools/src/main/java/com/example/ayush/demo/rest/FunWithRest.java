package com.example.ayush.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunWithRest {
    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/fortune")
    public String sayFortune() {
        return "your luck day today";
    }
}
