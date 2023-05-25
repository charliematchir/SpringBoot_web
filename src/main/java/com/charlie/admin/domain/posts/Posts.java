package com.charlie.admin.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


// Entity 를 통해 해당 클래스가 DB 테이블과 매칭될 클래스임을 선언
// 매칭되는 테이블 이름은 SalesTeam.java -> sales_team table

// Entity 클래스는 Setter 메소르드를 만들지 않는다.
// 만들게 되면 변경이 어디서 언제 일어나는지 찾기 힘들기 때문에
// 변경이 필요한 경우 명시적인 메소드를 추가한다.
// DB에 값 삽입은 최종값을 생성자를 통해 넣는것이고, 변경은 추후에 경우에 맞는 public 메소드로 !

// Getter는 클래스 내 모든 필드 gettter 메소드 생성, NoArgs 는 기본 생성자 자동 추가( public Posts() {} )
@Getter
@NoArgsConstructor
@Entity
public class Posts {
    // ID 는 테이블의 PK 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 테이블의 칼럼을 나타내며 선언 안해도 됨 (추가 변경 옵션이 있을때 사용)
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // builder는 해당 클래스의 빌더 패턴 클래스를 생성
    // 생성자 대신 builder를 쓰는 이유는 param의 위치가 변경되지 않게 하기 위함.
    // ex) Posts.builder().title(title).content(content) ... 이런식으로 사용함
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
