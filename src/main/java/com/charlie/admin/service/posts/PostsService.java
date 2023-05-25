package com.charlie.admin.service.posts;

import com.charlie.admin.domain.posts.PostsRepository;
import com.charlie.admin.web.dto.PostsSaveRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// bean 주입 받는 방식은 Autowired, setter, 생성자 세가지가 있음
// 이 중 생성자로 주입 받는 방식을 가장 권장한다.
//  autowired 없는건  RequiredArgsConstructor 가 해결하기 때문
// final이 선언된 모든 필드를 인자값으로 하는 생성자를 롬북이 대신 생성 해준것
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
