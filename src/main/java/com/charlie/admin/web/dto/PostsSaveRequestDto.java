package com.charlie.admin.web.dto;

import com.charlie.admin.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


// Entity 클래스와 거의 유사함에도 Dto 클래스를 따로 만들어준것
// Entity 클래스는 DB와 맞닿아 있기에  Req/Response 클래스로 사용해서 안되기 때문에

// 대부분의 서비스 클래스나 비지니스 로직들은 Entity 클래스를 기준으로 동작하기 때문에
// Entity 클래스가 변경되면 여러곳에 영향을 끼친다.
// Req와 Response영 Dto는 view만을 위한 클래스라 많은 변경이 필요함
// 그래서 View Layer 와 DB Layer의 분리를 해야함

// Entity 클래스와 Controller에서 쓸 Dto는 꼭 분리해서 사용해라!
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
