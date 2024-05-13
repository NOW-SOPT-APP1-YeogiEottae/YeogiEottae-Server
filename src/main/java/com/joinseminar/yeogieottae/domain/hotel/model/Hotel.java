package com.joinseminar.yeogieottae.domain.hotel.model;

import com.joinseminar.yeogieottae.domain.room.model.Room;
import com.joinseminar.yeogieottae.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hotel extends BaseEntity {

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

    @Builder(access = PRIVATE)
    private Hotel(final String hotelName, final String star, final String location,
                  final double reviewRate, final int reviewCount)
    {
        this.hotelName = hotelName;
        this.star = star;
        this.location = location;
        this.reviewRate = reviewRate;
        this.reviewCount = reviewCount;
    }

    // 생성 메서드 정의
    public static Hotel createHotel(final String hotelName, final String star, final String location,
                                    final double reviewRate, final int reviewCount)
    {
        return Hotel.builder()
                .hotelName(hotelName)
                .star(star)
                .location(location)
                .reviewRate(reviewRate)
                .reviewCount(reviewCount)
                .build();
    }
}
