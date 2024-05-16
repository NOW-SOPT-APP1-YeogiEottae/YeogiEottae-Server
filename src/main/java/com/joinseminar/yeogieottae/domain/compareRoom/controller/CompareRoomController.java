package com.joinseminar.yeogieottae.domain.compareRoom.controller;

import com.joinseminar.yeogieottae.domain.compareRoom.dto.ComPareRoomRequest;
import com.joinseminar.yeogieottae.domain.compareRoom.dto.response.CompareRoomResponse;
import com.joinseminar.yeogieottae.domain.compareRoom.service.CompareRoomService;
import com.joinseminar.yeogieottae.global.common.dto.SuccessResponse;
import com.joinseminar.yeogieottae.global.exception.enums.SuccessMessage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joinseminar.yeogieottae.global.exception.enums.SuccessMessage.ADD_COMPARE_TO_LIST_BY_ID;
import static com.joinseminar.yeogieottae.global.exception.enums.SuccessMessage.GET_COMPARE_TO_LIST_BY_ID;

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

    @GetMapping
    @Operation(summary = "비교하기 목록 조회 API", description = "비교하기 목록을 조회하는 API 구현")
    public ResponseEntity<SuccessResponse<List<CompareRoomResponse>>> getCompareRooms(
            @RequestHeader Long userId,
            @RequestParam(value = "price", required = false) String price,
            @RequestParam(value = "review", required = false) String review){
        List<CompareRoomResponse> compareRooms = compareRoomService.getCompareRooms(userId, price, review);
        return ResponseEntity.ok(SuccessResponse.of(GET_COMPARE_TO_LIST_BY_ID, compareRooms));
    }
}
