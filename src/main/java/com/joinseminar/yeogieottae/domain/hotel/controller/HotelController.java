package com.joinseminar.yeogieottae.domain.hotel.controller;

import com.joinseminar.yeogieottae.domain.hotel.dto.response.HotelDetailResponse;
import com.joinseminar.yeogieottae.domain.hotel.model.Hotel;
import com.joinseminar.yeogieottae.domain.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/hotels/{hotelId}")
    public HotelDetailResponse getHotelDetail(@PathVariable Long hotelId) {
        return hotelService.getHotelDetail(hotelId);
    }
}
