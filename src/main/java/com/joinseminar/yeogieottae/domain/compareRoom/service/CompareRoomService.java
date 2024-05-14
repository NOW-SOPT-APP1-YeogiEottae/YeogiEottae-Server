package com.joinseminar.yeogieottae.domain.compareRoom.service;

import com.joinseminar.yeogieottae.domain.compareRoom.dto.ComPareRoomRequest;

public interface CompareRoomService {

    void addRoomsToCompare(Long userId, ComPareRoomRequest request);
}
