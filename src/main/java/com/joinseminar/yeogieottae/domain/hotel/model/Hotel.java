package com.joinseminar.yeogieottae.domain.hotel.model;

import com.joinseminar.yeogieottae.domain.room.model.Room;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId; // 호텔 ID

    @Column(nullable = false, length = 32)
    private String hotelName; // 호텔명

    @Column(nullable = false, length = 8)
    private String star; // 호텔 등급

    @Column(nullable = false, length = 128)
    private String location; // 호텔 위치

    private double reviewRate; // 리뷰 별점

    private int reviewCount; // 리뷰 개수

    private boolean isLiked; // 찜 목록 추가 여부

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> roomList = new ArrayList<>();
}
