package com.charlie.admin.service;

import com.charlie.admin.domain.posts.Posts;
import com.charlie.admin.domain.posts.PostsRepository;
import com.charlie.admin.web.dto.PostsResponseDto;
import com.charlie.admin.web.dto.PostsSaveRequestDto;
import com.charlie.admin.web.dto.PostsUpdateRequestDto;
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


    // update 내에서 DB에 쿼리를 날리는 부분이 없음
    // 이건 JPA의 영속성 컨텍스트 (엔티티 영구 저장 환경) 때문
    // 애플리케이션과 DB 사이의 객체 보관하는 가상의 DB

    // Spring Data JPA쓰면 기본값으로 JPA entitiy manager가 활성화 되고,
    // 그 상태에서 transaction에서 DB 데이터 가져오면 이 데이터는 영속성 컨택스트 유지가 됨
    // 이때 데이터값 변경하면 Transaction 끝나는 시점에 해당 테이블에 변경 반영함

    // 즉 Entity 객체 데이터 값만 변경해도 update 쿼리 없이도 DB 수정됨 ( Dirty Checking )
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).
                orElseThrow( () -> new IllegalArgumentException("해당 사용자를 찾을수 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById( Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
}
