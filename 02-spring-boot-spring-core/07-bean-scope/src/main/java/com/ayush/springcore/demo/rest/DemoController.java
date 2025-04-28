package com.ayush.springcore.demo.rest;

import com.ayush.springcore.demo.commons.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach myAnotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach myCoach,
            @Qualifier("cricketCoach") Coach myAnotherCoach
            ) {
        this.myCoach = myCoach;
        this.myAnotherCoach = myAnotherCoach;
    }

    @GetMapping("/checkBeans")
    public String checkBeans(){
        return "check if myCoach == myAnotherCoach " + (myCoach == myAnotherCoach);
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
