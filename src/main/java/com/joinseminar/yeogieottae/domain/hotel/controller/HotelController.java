package com.joinseminar.yeogieottae.domain.hotel.controller;

import com.joinseminar.yeogieottae.domain.hotel.dto.response.HotelDetailResponse;
import com.joinseminar.yeogieottae.domain.hotel.model.Hotel;
import com.joinseminar.yeogieottae.domain.hotel.service.HotelService;
import com.joinseminar.yeogieottae.global.common.dto.SuccessResponse;
import com.joinseminar.yeogieottae.global.exception.enums.SuccessMessage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.joinseminar.yeogieottae.global.exception.enums.SuccessMessage.GET_HOTEL_DETAIL_SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class HotelController {

    private final HotelService hotelService;

    @Operation(summary = "호텔 상세 조회 API", description = "호텔 상세 조회 API 구현")
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<SuccessResponse<HotelDetailResponse>> getHotelDetail(@PathVariable Long hotelId) {
        return ResponseEntity.ok(
                SuccessResponse.of(GET_HOTEL_DETAIL_SUCCESS,hotelService.getHotelDetail(hotelId))
        );
    }
}
