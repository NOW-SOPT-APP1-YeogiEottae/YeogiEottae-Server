package com.joinseminar.yeogieottae.domain.compareRoom.controller;

import com.joinseminar.yeogieottae.domain.compareRoom.dto.request.ComPareRoomRequest;
import com.joinseminar.yeogieottae.domain.compareRoom.dto.request.DeleteCompareRoomRequest;
import com.joinseminar.yeogieottae.domain.compareRoom.dto.response.LikedRoomListResponse;
import com.joinseminar.yeogieottae.domain.compareRoom.dto.response.CompareRoomResponse;

import com.joinseminar.yeogieottae.domain.compareRoom.service.CompareRoomService;
import com.joinseminar.yeogieottae.global.common.dto.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joinseminar.yeogieottae.global.exception.enums.SuccessMessage.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/compare-rooms")
public class CompareRoomController {

    private final CompareRoomService compareRoomService;

    @PostMapping("/likes")
    @Operation(summary = "비교하기 목록 > 찜 추가 API", description = "비교하기 목록에 찜 목록 추가 API 구현")
    public ResponseEntity<SuccessResponse> addRoomsToCompare(
            @RequestHeader String userId,
            @RequestBody ComPareRoomRequest request){
        compareRoomService.addRoomsToCompare(Long.valueOf(userId), request);
        return ResponseEntity.ok(SuccessResponse.of(ADD_COMPARE_TO_LIST_BY_ID));
    }

    @GetMapping("/likes")
    @Operation(summary = "비교하기 > 내가 찜한 객실 목록 조회 API", description = "비교하기에서 추가 버튼 클릭시 뜨는 찜 목록 API 구현")
    public ResponseEntity<SuccessResponse<LikedRoomListResponse>> getLikedRooms(@RequestHeader String userId) {
        return ResponseEntity.ok(SuccessResponse.of(
                GET_LIKED_ROOM_NOT_IN_COMPARE_SUCCESS,
                compareRoomService.getLikedRooms(Long.valueOf(userId)))
        );
    }

    @GetMapping
    @Operation(summary = "비교하기 목록 조회 API", description = "비교하기 목록을 조회하는 API 구현")
    public ResponseEntity<SuccessResponse<List<CompareRoomResponse>>> getCompareRooms(
            @RequestHeader String userId,
            @RequestParam(value = "price", required = false) String price,
            @RequestParam(value = "review", required = false) String review) {
        List<CompareRoomResponse> compareRooms = compareRoomService.getCompareRooms(Long.valueOf(userId), price, review);
        return ResponseEntity.ok(SuccessResponse.of(GET_COMPARE_TO_LIST_BY_ID, compareRooms));
    }


    @DeleteMapping("/likes")
    @Operation(summary = "비교하기 목록에서 찜 삭제 API", description = "비교하기 목록에서 찜 삭제 API 구현")
    public ResponseEntity<SuccessResponse> deleteCompareRoom(
            @RequestHeader String userId,
            @RequestBody DeleteCompareRoomRequest request) {
        compareRoomService.deleteCompareRoom(Long.valueOf(userId), request.roomId());
        return ResponseEntity.ok(SuccessResponse.of(DELETE_COMPARE_LIKE_SUCCESS));
    }
}
