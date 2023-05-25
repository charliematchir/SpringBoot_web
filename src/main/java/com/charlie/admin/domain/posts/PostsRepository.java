package com.charlie.admin.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// 자동으로 CRUD 메소드 생성
// Entity 클래스와 같은 위치에 있어야함
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
