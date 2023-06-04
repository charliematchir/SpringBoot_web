package com.charlie.admin.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// target은 어노테이션의 생성 위치 지정
// 메소드의 파라미터로 선언된 객체에서 사용할 수 있다.

// @interface는 이 파일을 어노테이션 클래스로 지정한다
// LoginUser라는 이름을 가진 어노테이션이 생성된 것
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
