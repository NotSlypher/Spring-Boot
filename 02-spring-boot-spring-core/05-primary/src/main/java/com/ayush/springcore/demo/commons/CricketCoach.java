package com.ayush.springcore.demo.commons;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach {
    public String getDailyWorkout() {
        return "Practice throwing ball for 15 minutes";
    }
}
