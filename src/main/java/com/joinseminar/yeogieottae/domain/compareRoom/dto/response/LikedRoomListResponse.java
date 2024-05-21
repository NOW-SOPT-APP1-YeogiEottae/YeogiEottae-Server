package com.joinseminar.yeogieottae.domain.compareRoom.dto.response;

import java.util.List;

public record LikedRoomListResponse(
        List<LikedRoomDetailResponse> roomList
) {
    public static LikedRoomListResponse of(List<LikedRoomDetailResponse> room_list) {
        return new LikedRoomListResponse(room_list);
    }
}
