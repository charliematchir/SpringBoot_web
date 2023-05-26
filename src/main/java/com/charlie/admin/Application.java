package com.charlie.admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @~ does spring boot auto config, spring bean read write auto setting
// This should be project top since setting are read from here

// jpa auditing 활성화
@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // SpringApplication.run runs internal WAS
        // Do not need tomcat and only executing spring boot jar will do.
        SpringApplication.run(Application.class, args);
    }

}
