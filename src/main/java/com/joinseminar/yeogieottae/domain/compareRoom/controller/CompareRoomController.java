package com.joinseminar.yeogieottae.domain.compareRoom.controller;

import com.joinseminar.yeogieottae.domain.compareRoom.dto.ComPareRoomRequest;
import com.joinseminar.yeogieottae.domain.compareRoom.dto.LikedRoomListResponse;
import com.joinseminar.yeogieottae.domain.compareRoom.service.CompareRoomService;
import com.joinseminar.yeogieottae.global.common.dto.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.joinseminar.yeogieottae.global.exception.enums.SuccessMessage.ADD_COMPARE_TO_LIST_BY_ID;
import static com.joinseminar.yeogieottae.global.exception.enums.SuccessMessage.GET_LIKED_ROOM_NOT_IN_COMPARE_SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/compare-rooms")
public class CompareRoomController {

    private final CompareRoomService compareRoomService;

    @PostMapping("/likes")
    @Operation(summary = "비교하기 목록 > 찜 추가 API", description = "비교하기 목록에 찜 목록 추가 API 구현")
    public ResponseEntity<SuccessResponse> addRoomsToCompare(
            @RequestHeader Long userId,
            @RequestBody ComPareRoomRequest request){
        compareRoomService.addRoomsToCompare(userId, request);
        return ResponseEntity.ok(SuccessResponse.of(ADD_COMPARE_TO_LIST_BY_ID));
    }

    @GetMapping("/likes")
    @Operation(summary = "비교하기 > 내가 찜한 객실 목록 조회 API", description = "비교하기에서 추가 버튼 클릭시 뜨는 찜 목록 API 구현")
    public ResponseEntity<SuccessResponse<LikedRoomListResponse>> getLikedRooms(@RequestHeader Long userId) {
        return ResponseEntity.ok(SuccessResponse.of(
                GET_LIKED_ROOM_NOT_IN_COMPARE_SUCCESS,
                compareRoomService.getLikedRooms(userId))
        );
    }

}
