package com.joinseminar.yeogieottae.domain.compareRoom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CompareRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compareId; // 비교하기 목록 ID

    private Long roomId; // 객실 ID

    private Long userId; // 유저 ID
}
