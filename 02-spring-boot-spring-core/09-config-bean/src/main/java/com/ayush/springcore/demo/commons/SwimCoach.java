package com.ayush.springcore.demo.commons;

public class SwimCoach implements Coach {
    public SwimCoach() {
        System.out.println("SwimCoach constructor");
    }

    public String getDailyWorkout() {
        return "Practice swimming for 15 minutes";
    }
}
