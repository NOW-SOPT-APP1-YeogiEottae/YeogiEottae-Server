package com.joinseminar.yeogieottae.domain.compareRoom.dto;

import com.joinseminar.yeogieottae.domain.room.model.Room;
import lombok.Builder;

@Builder
public record LikedRoomDetailResponse(
        Long room_id,
        String hotel_name,
        String room_name,
        String location,
        String image_url
) {
    public static LikedRoomDetailResponse of(final Room room) {
        return LikedRoomDetailResponse.builder()
                .room_id(room.getRoomId())
                .hotel_name(room.getHotel().getHotelName())
                .room_name(room.getRoomName())
                .location(room.getHotel().getLocation())
                .image_url(room.getRoomImage())
                .build();
    }
}
