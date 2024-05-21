package com.joinseminar.yeogieottae.domain.hotel.dto.response;

import com.joinseminar.yeogieottae.domain.hotel.model.Hotel;
import com.joinseminar.yeogieottae.domain.room.dto.response.RoomDetailResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record HotelDetailResponse(
        String hotelName,
        String star,
        String location,
        double reviewRate,
        int reviewCount,
        boolean isLiked,
        List<RoomDetailResponse> roomList
) {
    public static HotelDetailResponse of(final Hotel hotel, final List<RoomDetailResponse> room_list) {
        return HotelDetailResponse.builder()
                .hotelName(hotel.getHotelName())
                .star(hotel.getStar())
                .location(hotel.getLocation())
                .reviewRate(hotel.getReviewRate())
                .reviewCount(hotel.getReviewCount())
                .roomList(room_list)
                .build();
    }
}
