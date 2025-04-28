package com.ayush.springcore.demo.commons;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    // post contruct method
    @PostConstruct
    public void doPostConstructStuff() {
        System.out.println("in doPostConstructStuff " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doPreDestroyStuff() {
        System.out.println("in doPreDestroyStuff " + getClass().getSimpleName());
    }

    public String getDailyWorkout() {
        return "Practice throwing ball for 15 minutes";
    }
}
