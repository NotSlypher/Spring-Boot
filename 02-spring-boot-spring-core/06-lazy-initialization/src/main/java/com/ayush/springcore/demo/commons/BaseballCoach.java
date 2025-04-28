package com.ayush.springcore.demo.commons;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BaseballCoach implements Coach{
    public BaseballCoach() {
        System.out.println("Inside constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice batting for 10 minutes";
    }
}
