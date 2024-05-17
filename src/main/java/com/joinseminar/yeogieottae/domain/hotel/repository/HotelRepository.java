package com.joinseminar.yeogieottae.domain.hotel.repository;

import com.joinseminar.yeogieottae.domain.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findById(Long hotelId);
}
