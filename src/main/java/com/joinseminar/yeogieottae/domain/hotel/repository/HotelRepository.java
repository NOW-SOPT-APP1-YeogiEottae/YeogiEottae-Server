package com.joinseminar.yeogieottae.domain.hotel.repository;

import com.joinseminar.yeogieottae.domain.hotel.model.Hotel;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface HotelRepository extends Repository<Hotel, Long> {
    Optional<Hotel> findById(Long hotelId);
}
