package com.joinseminar.yeogieottae.domain.room.dto.response;

import com.joinseminar.yeogieottae.domain.room.model.Room;
import lombok.Builder;

@Builder
public record RoomDetailResponse(
        Long roomId,
        String roomName,
        int price,
        String startTime,
        String endTime,
        String imageUrl,
        boolean isLiked
) {
    public static RoomDetailResponse of(final Room room) {
        return RoomDetailResponse.builder()
                .roomId(room.getRoomId())
                .roomName(room.getRoomName())
                .price(room.getPrice())
                .startTime(room.getStartTime())
                .endTime(room.getEndTime())
                .imageUrl(room.getRoomImage())
                .isLiked(room.isLiked())
                .build();
    }
}
