package com.example.ayush.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunWithRest {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/fortune")
    public String sayFortune() {
        return "your luck day today";
    }

    @GetMapping("/team-info")
    public String sayTeamInfo() {
        return "team " + teamName + ", " + coachName;
    }
}
