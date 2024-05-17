package com.joinseminar.yeogieottae.domain.room.repository;

import com.joinseminar.yeogieottae.domain.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findById(Long roomId);
}
