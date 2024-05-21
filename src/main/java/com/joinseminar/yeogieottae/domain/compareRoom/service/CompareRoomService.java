package com.joinseminar.yeogieottae.domain.compareRoom.service;

import com.joinseminar.yeogieottae.domain.compareRoom.dto.request.ComPareRoomRequest;
import com.joinseminar.yeogieottae.domain.compareRoom.dto.response.LikedRoomListResponse;
import com.joinseminar.yeogieottae.domain.compareRoom.dto.response.CompareRoomResponse;

import java.util.List;

public interface CompareRoomService {
    // 비교하기 목록 불러오기
    List<CompareRoomResponse> getCompareRooms(Long userId, String price, String review);

    // 비교하기 목록에 추가하기
    void addRoomsToCompare(Long userId, ComPareRoomRequest request);
    LikedRoomListResponse getLikedRooms(Long userId);

    // 비교하기 목록 삭제하기
    void deleteCompareRoom(Long userId, Long roomId);
}
