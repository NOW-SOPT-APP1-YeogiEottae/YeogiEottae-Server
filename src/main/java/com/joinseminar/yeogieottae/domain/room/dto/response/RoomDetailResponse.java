package com.joinseminar.yeogieottae.domain.room.dto.response;

import com.joinseminar.yeogieottae.domain.room.model.Room;
import lombok.Builder;

@Builder
public record RoomDetailResponse(
        Long room_id,
        String room_name,
        int price,
        String start_time,
        String end_time,
        String image_url,
        boolean is_liked
) {
    public static RoomDetailResponse of(final Room room) {
        return RoomDetailResponse.builder()
                .room_id(room.getRoomId())
                .room_name(room.getRoomName())
                .price(room.getPrice())
                .start_time(room.getStartTime())
                .end_time(room.getEndTime())
                .image_url(room.getRoomImage())
                .is_liked(room.isLiked())
                .build();
    }
}
