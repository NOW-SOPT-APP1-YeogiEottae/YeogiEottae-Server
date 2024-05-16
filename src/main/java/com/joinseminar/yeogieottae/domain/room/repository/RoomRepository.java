package com.joinseminar.yeogieottae.domain.room.repository;

import com.joinseminar.yeogieottae.domain.room.model.Room;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface RoomRepository extends Repository<Room, Long> {

    Optional<Room> findById(Long roomId);
}
