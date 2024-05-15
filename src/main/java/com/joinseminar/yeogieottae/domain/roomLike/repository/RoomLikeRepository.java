package com.joinseminar.yeogieottae.domain.roomLike.repository;

import com.joinseminar.yeogieottae.domain.roomLike.model.RoomLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomLikeRepository extends JpaRepository<RoomLike, Long> {

    @Query("SELECT r1.roomId FROM RoomLike r1 WHERE r1.roomId IN :roomIds AND r1.user.userId = :userId")
    List<Long> findExistingRoomIds(@Param("userId") Long userId, @Param("roomIds") List<Long> roomIds);
}