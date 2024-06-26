package com.joinseminar.yeogieottae.domain.hotel.service;

import com.joinseminar.yeogieottae.domain.hotel.dto.response.HotelDetailResponse;
import com.joinseminar.yeogieottae.domain.hotel.model.Hotel;
import com.joinseminar.yeogieottae.domain.hotel.repository.HotelRepository;
import com.joinseminar.yeogieottae.domain.room.dto.response.RoomDetailResponse;
import com.joinseminar.yeogieottae.domain.room.model.Room;
import com.joinseminar.yeogieottae.global.exception.model.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.joinseminar.yeogieottae.global.exception.enums.ErrorMessage.HOTEL_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelDetailResponse getHotelDetail(final Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(
                ()-> new CustomException(HOTEL_NOT_FOUND)
        );

        List<RoomDetailResponse> roomDetailResponses = hotel.getRoomList()
                .stream()
                .sorted(Comparator.comparing(Room::getRoomId))
                .map(RoomDetailResponse::of)
                .toList();

        return HotelDetailResponse.of(hotel, roomDetailResponses);
    }
}
