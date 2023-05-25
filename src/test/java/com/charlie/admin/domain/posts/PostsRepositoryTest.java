package com.charlie.admin.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    // 단위 테스트 끝날때마다 수행되는 메소드 지정
    // 테스트용 DB인 H2에서 여러 테스트 동시 진행시 오류 날수 있어서
    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void savepost_Load() {
        String title = "title_test";
        String content = "content_test";

        // post Table에 insert / Update 쿼리
        // id 같이 주면 update, 없으면 insert
        postsRepository.save(Posts.builder().title(title).content(content).author("charlie").build());

        List<Posts> postsList = postsRepository.findAll();
        Posts posts  = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
