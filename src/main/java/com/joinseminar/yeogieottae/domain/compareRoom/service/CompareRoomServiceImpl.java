package com.joinseminar.yeogieottae.domain.compareRoom.service;

import com.joinseminar.yeogieottae.domain.compareRoom.dto.ComPareRoomRequest;
import com.joinseminar.yeogieottae.domain.compareRoom.dto.LikedRoomDetailResponse;
import com.joinseminar.yeogieottae.domain.compareRoom.dto.LikedRoomListResponse;
import com.joinseminar.yeogieottae.domain.compareRoom.model.CompareRoom;
import com.joinseminar.yeogieottae.domain.compareRoom.repository.CompareRoomRepository;
import com.joinseminar.yeogieottae.domain.room.model.Room;
import com.joinseminar.yeogieottae.domain.roomLike.model.RoomLike;
import com.joinseminar.yeogieottae.domain.roomLike.repository.RoomLikeRepository;
import com.joinseminar.yeogieottae.domain.user.model.User;
import com.joinseminar.yeogieottae.global.exception.enums.ErrorMessage;
import com.joinseminar.yeogieottae.global.exception.model.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompareRoomServiceImpl implements CompareRoomService {

    private final CompareRoomRepository compareRoomRepository;
    private final RoomLikeRepository roomLikeRepository;

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
