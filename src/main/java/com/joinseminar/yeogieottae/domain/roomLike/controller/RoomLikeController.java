package com.joinseminar.yeogieottae.domain.roomLike.controller;

import com.joinseminar.yeogieottae.domain.roomLike.dto.DeleteHotelOrRoomLikeRequest;
import com.joinseminar.yeogieottae.domain.roomLike.dto.PostHotelOrRoomLikeRequest;
import com.joinseminar.yeogieottae.domain.roomLike.service.RoomLikeService;
import com.joinseminar.yeogieottae.global.common.dto.SuccessResponse;
import com.joinseminar.yeogieottae.global.exception.enums.SuccessMessage;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.joinseminar.yeogieottae.global.exception.enums.SuccessMessage.DELETE_LIKE_SUCCESS;
import static com.joinseminar.yeogieottae.global.exception.enums.SuccessMessage.POST_LIKE_SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RoomLikeController {

    private final RoomLikeService roomLikeService;

    @PostMapping("/likes")
    @Operation(summary = "찜(호텔&객실) 추가 API", description = "찜(호텔&객실) 추가 API 구현")
    public ResponseEntity<SuccessResponse> createHotelOrRoomLike(
            @RequestHeader Long userId,
            @RequestParam(value = "roomType") int roomType,
            @Valid @RequestBody PostHotelOrRoomLikeRequest postHotelOrRoomLikeRequest
    ) {
        roomLikeService.createHotelOrRoomLike(userId, roomType, postHotelOrRoomLikeRequest.id());
        return ResponseEntity.status(HttpStatus.CREATED).body((SuccessResponse.of(POST_LIKE_SUCCESS)));
    }

    @DeleteMapping("/likes")
    @Operation(summary = "찜(호텔&객실) 삭제(취소) API", description = "찜(호텔&객실) 삭제(취소) API 구현")
    public ResponseEntity<SuccessResponse> deleteHotelOrRoomLike(
            @RequestHeader Long userId,
            @RequestParam(value = "roomType") int roomType,
            @Valid @RequestBody DeleteHotelOrRoomLikeRequest deleteHotelOrRoomLikeRequest
    ) {
        roomLikeService.deleteHotelOrRoomLike(userId, roomType, deleteHotelOrRoomLikeRequest.id());
        return ResponseEntity.ok(SuccessResponse.of(DELETE_LIKE_SUCCESS));
    }
}
