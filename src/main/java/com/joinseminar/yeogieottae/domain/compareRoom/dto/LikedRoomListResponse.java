package com.joinseminar.yeogieottae.domain.compareRoom.dto;

import com.joinseminar.yeogieottae.domain.room.model.Room;
import com.joinseminar.yeogieottae.domain.roomLike.model.RoomLike;

import java.util.List;

public record LikedRoomListResponse(
        List<LikedRoomDetailResponse> room_list
) {
    public static LikedRoomListResponse of(List<LikedRoomDetailResponse> room_list) {
        return new LikedRoomListResponse(room_list);
    }
}
