package com.joinseminar.yeogieottae.domain.compareRoom.service;

import com.joinseminar.yeogieottae.domain.compareRoom.dto.ComPareRoomRequest;
import com.joinseminar.yeogieottae.domain.compareRoom.dto.LikedRoomListResponse;

public interface CompareRoomService {

    void addRoomsToCompare(Long userId, ComPareRoomRequest request);
    LikedRoomListResponse getLikedRooms(Long userId);
}
