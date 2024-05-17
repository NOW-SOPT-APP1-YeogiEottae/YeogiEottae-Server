package com.joinseminar.yeogieottae.domain.roomLike.service;

import com.joinseminar.yeogieottae.domain.hotel.model.Hotel;
import com.joinseminar.yeogieottae.domain.hotel.repository.HotelRepository;
import com.joinseminar.yeogieottae.domain.hotelLike.model.HotelLike;
import com.joinseminar.yeogieottae.domain.hotelLike.repository.HotelLikeRepository;
import com.joinseminar.yeogieottae.domain.room.model.Room;
import com.joinseminar.yeogieottae.domain.room.repository.RoomRepository;
import com.joinseminar.yeogieottae.domain.roomLike.model.RoomLike;
import com.joinseminar.yeogieottae.domain.roomLike.repository.RoomLikeRepository;
import com.joinseminar.yeogieottae.domain.user.model.User;
import com.joinseminar.yeogieottae.domain.user.repository.UserRepository;
import com.joinseminar.yeogieottae.global.exception.model.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

import static com.joinseminar.yeogieottae.global.exception.enums.ErrorMessage.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoomLikeService {

    private final HotelRepository hotelRepository;
    private final UserRepository userRepository;
    private final HotelLikeRepository hotelLikeRepository;
    private final RoomRepository roomRepository;
    private final RoomLikeRepository roomLikeRepository;

    @Transactional
    public void createHotelOrRoomLike(final Long userId, final int roomType, final Long hotelOrRoomId) {
        User user = findUser(userId);

        Optional<HotelLike> byHotelIdAndUser;

        if (roomType == 0) {
            findHotelLike(user, hotelOrRoomId).ifPresent(
                    m -> { throw new CustomException(ALREADY_LIKED_HOTEL);}
            );
            Hotel hotel = hotelRepository.findById(hotelOrRoomId).orElseThrow(
                    () -> new CustomException(HOTEL_NOT_FOUND)
            );

            //해당 호텔에 속한 객실을 이미 찜했을 경우 hotel_like_id null 아니게 update
            roomLikeRepository.updateHotelLikeId(user, hotelLikeRepository.save(
                    HotelLike.createHotelLike(user, hotelOrRoomId)), hotel.getRoomList().stream().map(Room::getRoomId).toList()
            );

        } else if (roomType == 1) {
            findRoomLike(user, hotelOrRoomId).ifPresent(
                    m -> { throw new CustomException(ALREADY_LIKED_ROOM);}
            );
            Room room = roomRepository.findById(hotelOrRoomId).orElseThrow(
                    () -> new CustomException(ROOM_NOT_FOUND)
            );

            //해당 객실의 호텔을 이미 찜한 상태라면 roomlike가 hotellike를 참조할 수 있도록
            findHotelLike(user, room.getHotel().getHotelId()).ifPresentOrElse(
                            hotelLike -> roomLikeRepository.save(RoomLike.createRoomLike(hotelLike, user, hotelOrRoomId)),
                            () -> roomLikeRepository.save(RoomLike.createRoomLike(null, user, hotelOrRoomId))
                    );
        }
    }

    @Transactional
    public void deleteHotelOrRoomLike(final Long userId, final int roomType, final Long hotelOrRoomId) {
        User user = findUser(userId);

        if (roomType == 0) {
            findHotelLike(user, hotelOrRoomId).ifPresent(
                    a ->{roomLikeRepository.updateHotelLikeId(user, a);
                        hotelLikeRepository.deleteByHotelLikeId(a.getHotelLikeId());}
            );
        } else if(roomType == 1) {
            findRoomLike(user, hotelOrRoomId).ifPresent(
                    m -> roomLikeRepository.deleteById(m.getRoomLikeId())
            );
        }
    }

    public Optional<HotelLike> findHotelLike(User user, Long hotelId) {
        return hotelLikeRepository.findByHotelIdAndUser(hotelId, user);
    }

    public Optional<RoomLike> findRoomLike(User user, Long roomId) {
        return roomLikeRepository.findByRoomIdAndUser(roomId, user);
    }

    public User findUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                ()-> new CustomException(USER_NOT_FOUND)
        );
    }
}
