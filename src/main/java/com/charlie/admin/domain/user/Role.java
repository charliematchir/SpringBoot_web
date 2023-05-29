package com.charlie.admin.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 사용자의 권한을 관리할 enum 클래스임
@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;

}
