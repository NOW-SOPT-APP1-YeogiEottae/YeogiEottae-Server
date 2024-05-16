package com.joinseminar.yeogieottae.domain.hotelLike.repository;

import com.joinseminar.yeogieottae.domain.hotelLike.model.HotelLike;
import com.joinseminar.yeogieottae.domain.user.model.User;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface HotelLikeRepository extends Repository<HotelLike, Long> {
    void save(HotelLike hotelLike);
    Optional<HotelLike> findByHotelIdAndUser(Long hotelId, User userId);
}
