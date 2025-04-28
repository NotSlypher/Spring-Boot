package com.ayush.springcore.demo.commons;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
