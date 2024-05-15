package com.joinseminar.yeogieottae.domain.roomLike.repository;

import com.joinseminar.yeogieottae.domain.room.model.Room;
import com.joinseminar.yeogieottae.domain.roomLike.model.RoomLike;
import com.joinseminar.yeogieottae.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RoomLikeRepository extends JpaRepository<RoomLike, Long> {

    @Query("SELECT r1.roomId FROM RoomLike r1 WHERE r1.roomId IN :roomIds AND r1.user.userId = :userId")
    List<Long> findExistingRoomIds(@Param("userId") Long userId, @Param("roomIds") List<Long> roomIds);

    @Query("SELECT rm FROM RoomLike r " +
            "left join CompareRoom c on r.roomId = c.roomId " +
            "join Room rm on rm.roomId = r.roomId " +
            "where r.user.userId = :userId and c.compareId IS null")
    List<Room> findByUserIdNotInCompareRoom(Long userId);
}
