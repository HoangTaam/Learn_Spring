package com.uit.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication(scanBasePackages = {"com.uit"})
public class UserApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UserApplication.class,args);
        System.out.println("Security config: " + context.getBean("securityFilterChain"));
    }
}