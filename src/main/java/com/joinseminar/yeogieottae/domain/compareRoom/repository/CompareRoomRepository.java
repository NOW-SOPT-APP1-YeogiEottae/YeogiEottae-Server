package com.joinseminar.yeogieottae.domain.compareRoom.repository;

import com.joinseminar.yeogieottae.domain.compareRoom.model.CompareRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompareRoomRepository extends JpaRepository<CompareRoom, Long> {

    //이미 비교하기 목록에 추가된 roomId를 확인하는 메서드
    @Query("SELECT cr.roomId FROM CompareRoom cr where cr.userId = :userId AND cr.roomId IN :roomIds")
    List<Long> findAlreadyComparedRoomIds(@Param("userId") Long userId, @Param("roomIds") List<Long> roomIds);
}
