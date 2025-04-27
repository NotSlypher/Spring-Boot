package com.ayush.springcore.demo.commons;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice batting for 10 minutes";
    }
}
