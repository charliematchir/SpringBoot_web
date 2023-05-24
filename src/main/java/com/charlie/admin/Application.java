package com.charlie.admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @~ does spring boot auto config, spring bean read write auto setting
// This should be project top since setting are read from here
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // SpringApplication.run runs internal WAS
        // Do not need tomcat and only executing spring boot jar will do.
        SpringApplication.run(Application.class, args);
    }

}