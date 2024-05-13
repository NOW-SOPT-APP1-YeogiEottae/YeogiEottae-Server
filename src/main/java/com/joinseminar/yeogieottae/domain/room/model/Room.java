package com.joinseminar.yeogieottae.domain.room.model;

import com.joinseminar.yeogieottae.domain.hotel.model.Hotel;
import com.joinseminar.yeogieottae.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Room extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId; // 객실 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId")
    private Hotel hotel; // 호텔 ID

    @Column(nullable = false, length = 32)
    private String roomName; // 객실명

    private int price; // 가격

    @Column(nullable = false, length = 256)
    private String roomImage; // 객실 이미지 URL

    @Column(nullable = false, length = 16)
    private String startTime; // 입실 시간

    @Column(nullable = false, length = 16)
    private String endTime; // 퇴실 시간

    private boolean isLiked; // 찜 목록 추가 여부
}
