package com.charlie.admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @~ does spring boot auto config, spring bean read write auto setting
// This should be project top since setting are read from here

// jpa auditing 활성화
// 이걸 비활성화 한 이유는 이걸 사용하기 위해서는 최소 하나의 @Entity 클래스가 필요함
// WebMvcTest에서도 스캔하게 되어있다보니 오류가 생김
// 해서 여기서는 제외하고, Main의 config 패키지에 JpaConfig 생성해서 test를 제외하고
// main 에서만 JPAauditing이 가능하게 함
//@EnableJpaAuditing

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // SpringApplication.run runs internal WAS
        // Do not need tomcat and only executing spring boot jar will do.
        SpringApplication.run(Application.class, args);
    }

}
