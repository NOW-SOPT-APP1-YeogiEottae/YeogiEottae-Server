package com.joinseminar.yeogieottae.domain.compareRoom.dto.response;

import com.joinseminar.yeogieottae.domain.room.model.Room;
import lombok.Builder;

@Builder
public record CompareRoomResponse(
        Long roomId, // 객실 ID
        String hotelName, // 호텔명
        String roomName, // 객실명
        int price, // 객실 가격
        double reviewRate, // 호텔 리뷰 평점
        int reviewCount, // 호텔 리뷰 개수
        String imageUrl // 객실 이미지 URL
) {
    public static CompareRoomResponse of(final Room room) {
        return CompareRoomResponse.builder()
                .roomId(room.getRoomId())
                .hotelName(room.getHotel().getHotelName())
                .roomName(room.getRoomName())
                .price(room.getPrice())
                .reviewRate(room.getHotel().getReviewRate())
                .reviewCount(room.getHotel().getReviewCount())
                .imageUrl(room.getRoomImage())
                .build();
    }
}
