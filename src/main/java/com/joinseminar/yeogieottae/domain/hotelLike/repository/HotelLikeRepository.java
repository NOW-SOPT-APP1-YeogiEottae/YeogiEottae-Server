package com.joinseminar.yeogieottae.domain.hotelLike.repository;

import com.joinseminar.yeogieottae.domain.hotelLike.model.HotelLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelLikeRepository extends JpaRepository<HotelLike, Long> {

    @Query("SELECT hl FROM HotelLike hl WHERE hl.user.userId = :userId")
    List<HotelLike> findAllByUserId(@Param("userId") Long userId);
}
