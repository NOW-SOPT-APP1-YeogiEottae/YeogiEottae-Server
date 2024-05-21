package com.joinseminar.yeogieottae.domain.compareRoom.repository;

import com.joinseminar.yeogieottae.domain.compareRoom.dto.response.CompareRoomResponse;
import com.joinseminar.yeogieottae.domain.compareRoom.model.CompareRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompareRoomRepository extends JpaRepository<CompareRoom, Long> {

    List<CompareRoom> findAllByUserId(Long userId);

    //비교하기 목록에 추가된 userId를 확인하는 메서드
    @Query("SELECT new com.joinseminar.yeogieottae.domain.compareRoom.dto.response.CompareRoomResponse(" +
            "r.roomId, h.hotelName, r.roomName, r.price, h.reviewRate, h.reviewCount, r.roomImage) " +
            "FROM CompareRoom cr " +
            "JOIN Room r ON cr.roomId = r.roomId " +
            "JOIN Hotel h ON r.hotel.hotelId = h.hotelId " +
            "WHERE cr.userId = :userId")
    List<CompareRoomResponse> findCompareRoomsByUserId(@Param("userId") Long userId);

    //이미 비교하기 목록에 추가된 roomId를 확인하는 메서드
    @Query("SELECT cr.roomId FROM CompareRoom cr where cr.userId = :userId AND cr.roomId IN :roomIds")
    List<Long> findAlreadyComparedRoomIds(@Param("userId") Long userId, @Param("roomIds") List<Long> roomIds);

    //비교하기 목록의 개수를 반환하는 메서드
    long countByUserId(Long userId);

    //비교하기 목록을 삭제하는 메서드
    @Modifying
    @Query("DELETE FROM CompareRoom cr WHERE cr.roomId = :roomId AND cr.userId = :userId")
    void deleteByRoomIdAndUserId(@Param("roomId") Long roomId, @Param("userId") Long userId);
}
