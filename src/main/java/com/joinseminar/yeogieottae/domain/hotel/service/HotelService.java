package com.joinseminar.yeogieottae.domain.hotel.service;

import com.joinseminar.yeogieottae.domain.hotel.dto.response.HotelDetailResponse;
import com.joinseminar.yeogieottae.domain.hotel.model.Hotel;
import com.joinseminar.yeogieottae.domain.hotel.repository.HotelRepository;
import com.joinseminar.yeogieottae.domain.room.dto.response.RoomDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelDetailResponse getHotelDetail(final Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(
                ()-> new RuntimeException()
        );

        List<RoomDetailResponse> roomDetailResponses = hotel.getRoomList()
                .stream()
                .map(RoomDetailResponse::of)
                .toList();

        return HotelDetailResponse.of(hotel, roomDetailResponses);
    }
}
