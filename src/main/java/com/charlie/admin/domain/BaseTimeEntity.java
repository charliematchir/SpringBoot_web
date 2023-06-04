package com.charlie.admin.domain;


import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// MappedSuperclass는 entity가 해당 클래스 상속시 지금 클래스의 필드들(createDate... etc)도 칼럼으로 인식하도록 한다.
//  리스너는 해당 클래스에 auditing 기능 추가 (시간에 대해서 자동으로 값을 넣어주는 기능)
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    //entity 생성시 시간이 자동 저장
    @CreatedDate
    private LocalDateTime createdDate;

    // 값 변경시 시간 자동 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
