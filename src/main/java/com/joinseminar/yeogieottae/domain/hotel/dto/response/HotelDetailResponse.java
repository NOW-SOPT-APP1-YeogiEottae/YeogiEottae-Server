package com.joinseminar.yeogieottae.domain.hotel.dto.response;

import com.joinseminar.yeogieottae.domain.hotel.model.Hotel;
import com.joinseminar.yeogieottae.domain.room.dto.response.RoomDetailResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record HotelDetailResponse(
        String hotel_name,
        String star,
        String location,
        double review_rate,
        int review_count,
        boolean is_liked,
        List<RoomDetailResponse> room_list
) {
    public static HotelDetailResponse of(final Hotel hotel, final List<RoomDetailResponse> room_list) {
        return HotelDetailResponse.builder()
                .hotel_name(hotel.getHotelName())
                .star(hotel.getStar())
                .location(hotel.getLocation())
                .review_rate(hotel.getReviewRate())
                .review_count(hotel.getReviewCount())
                .room_list(room_list)
                .build();
    }
}
