package com.joinseminar.yeogieottae.domain.hotelLike.repository;

import com.joinseminar.yeogieottae.domain.hotelLike.model.HotelLike;
import com.joinseminar.yeogieottae.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HotelLikeRepository extends JpaRepository<HotelLike, Long> {
//    void save(HotelLike hotelLike);
    Optional<HotelLike> findByHotelIdAndUser(Long hotelId, User userId);

    @Query("SELECT hl FROM HotelLike hl WHERE hl.user.userId = :userId")
    List<HotelLike> findAllByUserId(@Param("userId") Long userId);

    void deleteByHotelLikeId(Long hotelLikeId);
}
