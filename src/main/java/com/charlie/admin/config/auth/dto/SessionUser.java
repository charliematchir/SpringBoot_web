package com.charlie.admin.config.auth.dto;

import com.charlie.admin.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

//SessionUser에는 인증된 사용자 정보만 필요하기에 3가지 필드만 선언
//세션에 저장하기 위해 SessionUser 대신 그냥 User 클래스를 쓰면 직렬화를 구현하지 않았다는 에러가 뜸
// User는 엔티티 클래스라서 다른 엔티티와 관계 형성 될 수 있음.
// 그럴경우 자식까지 직렬화 대상이 되니 성능 문제 생김
// 그래서 이럴 경우 직렬화 기능을 가진 세션 Dto 를 만들어줌

// 직렬화란 객체의 내용을 바이트 단위로 변환하여 송수신이 가능하도록 하는것을 의미함
// 오브젝트는 주소값의 참조 데이터일 뿐이기에, 주소값 내의 실체를 primitive한 형시으로 변환하는 작업을 직렬화라고 함
// https://okky.kr/questions/224715
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
