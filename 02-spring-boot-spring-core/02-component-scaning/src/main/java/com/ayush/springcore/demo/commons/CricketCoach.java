package com.ayush.springcore.demo.commons;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public String getDailyWorkout() {
        return "Practice throwing ball for 15 minutes.";
    }
}
