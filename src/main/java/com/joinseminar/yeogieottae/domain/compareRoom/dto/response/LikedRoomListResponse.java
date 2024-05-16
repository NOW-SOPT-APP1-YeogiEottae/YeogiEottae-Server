package com.joinseminar.yeogieottae.domain.compareRoom.dto.response;

import java.util.List;

public record LikedRoomListResponse(
        List<LikedRoomDetailResponse> room_list
) {
    public static LikedRoomListResponse of(List<LikedRoomDetailResponse> room_list) {
        return new LikedRoomListResponse(room_list);
    }
}
