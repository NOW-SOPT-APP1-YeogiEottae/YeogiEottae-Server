package com.joinseminar.yeogieottae.domain.compareRoom.model;

import com.joinseminar.yeogieottae.global.common.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompareRoom extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compareId; // 비교하기 목록 ID

    private Long roomId; // 객실 ID

    private Long userId; // 유저 ID

    @Builder(access = PRIVATE)
    private CompareRoom(final Long roomId, final Long userId) {
        this.roomId = roomId;
        this.userId = userId;
    }

    // 생성 메서드 정의
    public static CompareRoom createCompareRoom(final Long roomId, final Long userId){
        return CompareRoom.builder()
                .roomId(roomId)
                .userId(userId)
                .build();
    }
}
