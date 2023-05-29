package com.charlie.admin.config.auth;

import com.charlie.admin.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// EnableWebSecurity 는 스프링 웹 보안 설정 활성화
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // 앞에 전부는 h2 conslole 화면 사용하기 위해 옵션 disable한것
                .and()
                    .authorizeRequests() // URL별 권한 관리 설정 옵션의 시작점
                    // andMatchers는 URL별 혹은 HTTP 메소드 별로 권한관리 지정하는 옵션
                    // permitAll이 전체 열람 권한임
                    .andMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    // post 메소드인 /api/v1 주소의 API는 user 권한을 가진 사람만 가능하도록
                    .andMatchers("/api/v1/**").hasRole(Role.USER.name())
                    // 이외의 URL 들은 인증된 사용자만 가능하다
                    .anyRequest().authenticated()
                .and()
                    // 로그아웃 성공시 / 로
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login() // OAuth2 로그인 기능 설정 포인트
                        .userInfoEndpoint()  // 로그인 성공 이후 사용자 정보 가져올때의 설정
                            .userService(customOAuth2UserService); // 로그인 성공시 후속조치 진행할 UserService 구현체 등록
    }
}
