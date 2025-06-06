package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class EmployeeSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}password")
                .roles("EMPLOYEE")
                .build();
        return new InMemoryUserDetailsManager(john);
    }
}
