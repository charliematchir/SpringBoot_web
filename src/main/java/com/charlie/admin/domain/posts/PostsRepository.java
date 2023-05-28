package com.charlie.admin.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// 자동으로 CRUD 메소드 생성
// Entity 클래스와 같은 위치에 있어야함
public interface PostsRepository extends JpaRepository<Posts, Long> {

    // JPA 에서 제공하지 않는 메소드는 아래처림 Query 사용해도됨 (저 정도는 JPA도 가능함)
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
