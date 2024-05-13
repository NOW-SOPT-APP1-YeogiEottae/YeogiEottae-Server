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
}
