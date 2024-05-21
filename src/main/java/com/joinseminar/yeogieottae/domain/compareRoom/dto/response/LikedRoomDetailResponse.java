package com.joinseminar.yeogieottae.domain.compareRoom.dto.response;

import com.joinseminar.yeogieottae.domain.room.model.Room;
import lombok.Builder;

@Builder
public record LikedRoomDetailResponse(
        Long roomId,
        String hotelName,
        String roomName,
        String location,
        String imageUrl
) {
    public static LikedRoomDetailResponse of(final Room room) {
        return LikedRoomDetailResponse.builder()
                .roomId(room.getRoomId())
                .hotelName(room.getHotel().getHotelName())
                .roomName(room.getRoomName())
                .location(room.getHotel().getLocation())
                .imageUrl(room.getRoomImage())
                .build();
    }
}
