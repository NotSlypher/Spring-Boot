package com.spring.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String helloWorld(Model model){
        model.addAttribute("time", java.time.LocalDateTime.now());
        return "helloworld";
    }
}
