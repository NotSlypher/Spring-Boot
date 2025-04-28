package com.ayush.springcore.demo.commons;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public String getDailyWorkout() {
        return "Practice throwing ball for 15 minutes";
    }
}
