package com.joinseminar.yeogieottae.domain.compareRoom.service;

import com.joinseminar.yeogieottae.domain.compareRoom.dto.request.ComPareRoomRequest;
import com.joinseminar.yeogieottae.domain.compareRoom.dto.response.LikedRoomDetailResponse;
import com.joinseminar.yeogieottae.domain.compareRoom.dto.response.LikedRoomListResponse;
import com.joinseminar.yeogieottae.domain.compareRoom.dto.response.CompareRoomResponse;
import com.joinseminar.yeogieottae.domain.compareRoom.model.CompareRoom;
import com.joinseminar.yeogieottae.domain.compareRoom.repository.CompareRoomRepository;
import com.joinseminar.yeogieottae.domain.room.model.Room;
import com.joinseminar.yeogieottae.domain.roomLike.repository.RoomLikeRepository;
import com.joinseminar.yeogieottae.global.exception.enums.ErrorMessage;
import com.joinseminar.yeogieottae.global.exception.model.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompareRoomServiceImpl implements CompareRoomService {

    private final CompareRoomRepository compareRoomRepository;
    private final RoomLikeRepository roomLikeRepository;

    @Transactional
    @Override
    public List<CompareRoomResponse> getCompareRooms(Long userId, String price, String review) {
        List<CompareRoomResponse> roomResponses = compareRoomRepository.findCompareRoomsByUserId(userId);

        // 리뷰 정렬(높은순)
        if("1".equals(review)){
            roomResponses.sort((r1,r2) -> Double.compare(r1.reviewRate(), r2.reviewRate()));
        } else {
            roomResponses.sort((r1,r2) -> Double.compare(r2.reviewRate(), r1.reviewRate()));
        }

        // 가격 정렬하기(낮은순)
        if("1".equals(price)){
            roomResponses.sort((r1,r2) -> Integer.compare(r2.price(), r1.price()));
        } else {
            roomResponses.sort((r1,r2) -> Integer.compare(r1.price(), r2.price()));
        }

        return roomResponses;
    }

    @Transactional
    @Override
    public void addRoomsToCompare(Long userId, ComPareRoomRequest request) {
        List<Long> requestedRoomIds = request.roomId();

        // RoomLike 테이블에서 존재하는 roomId 가져오기
        List<Long> existingRoomIds = roomLikeRepository.findExistingRoomIds(userId, requestedRoomIds);

        // RoomLike 테이블에 없는 roomId가 있는지 확인하기
        List<Long> nonExistingRoomIds = requestedRoomIds.stream()
                .filter(roomId -> !existingRoomIds.contains(roomId))
                .collect(Collectors.toList());
        if(!nonExistingRoomIds.isEmpty()){
            throw new CustomException(ErrorMessage.LIKES_NOT_FOUND_BY_ID_EXCEPTION);
        }

        // 이미 비교하기 목록에 있는 roomId 가져오기
        List<Long> alreadyCompareRoomIds = compareRoomRepository.findAlreadyComparedRoomIds(userId, requestedRoomIds);

        // 추가할 roomId 목록 생성하기
        List<Long> roomIdsToAdd = requestedRoomIds.stream()
                .filter(roomId -> !alreadyCompareRoomIds.contains(roomId))
                .collect(Collectors.toList());

        // 현재 비교하기 항목이 5개를 초과하는지 확인하기
        long currentCompareRoomCount = compareRoomRepository.countByUserId(userId);

        if(currentCompareRoomCount + roomIdsToAdd.size() > 5){
            throw new CustomException(ErrorMessage.COMPARE_ROOM_LIMIT_EXCEEDED);
        }

        // 비교하기 목록에 추가된 항목의 is_compared를 true으로 변경하기
        roomLikeRepository.updateIsComparedByUserIdAndRoomIds(userId, roomIdsToAdd, true);

        List<CompareRoom> compareRooms = roomIdsToAdd.stream()
                .map(roomId -> CompareRoom.createCompareRoom(roomId, userId))
                .collect(Collectors.toList());

        compareRoomRepository.saveAll(compareRooms);
    }

    @Transactional(readOnly = true)
    @Override
    public LikedRoomListResponse getLikedRooms(Long userId) {
        List<Room> likedRoomsNotInCompareRoom = roomLikeRepository.findByUserIdNotInCompareRoom(userId);

        return LikedRoomListResponse.of(likedRoomsNotInCompareRoom.stream()
                        .map(LikedRoomDetailResponse::of)
                        .toList());
    }
}
