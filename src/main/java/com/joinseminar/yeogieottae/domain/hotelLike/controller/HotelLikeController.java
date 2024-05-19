package com.joinseminar.yeogieottae.domain.hotelLike.controller;

import com.joinseminar.yeogieottae.domain.hotelLike.dto.response.HotelLikeResponse;
import com.joinseminar.yeogieottae.domain.hotelLike.service.HotelLikeService;
import com.joinseminar.yeogieottae.global.common.dto.SuccessResponse;
import com.joinseminar.yeogieottae.global.exception.enums.SuccessMessage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/likes")
public class HotelLikeController {

    private final HotelLikeService hotelLikeService;

    @GetMapping
    @Operation(summary = "찜 목록 조회 API", description = "찜 목록을 정보를 조회하는 API 구현")
    public ResponseEntity<SuccessResponse<List<HotelLikeResponse>>> getLikes(
            @RequestHeader String userId
    ){
        List<HotelLikeResponse> likes = hotelLikeService.getLikes(Long.valueOf(userId));
        return ResponseEntity.ok(SuccessResponse.of(SuccessMessage.GET_LIKES_SUCCESS, likes));
    }
}
