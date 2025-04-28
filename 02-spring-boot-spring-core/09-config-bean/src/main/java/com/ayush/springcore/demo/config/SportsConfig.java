package com.ayush.springcore.demo.config;

import com.ayush.springcore.demo.commons.Coach;
import com.ayush.springcore.demo.commons.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
