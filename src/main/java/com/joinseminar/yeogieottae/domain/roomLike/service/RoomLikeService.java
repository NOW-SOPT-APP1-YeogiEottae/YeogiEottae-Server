package com.joinseminar.yeogieottae.domain.roomLike.service;

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

        Optional<HotelLike> byHotelIdAndUser = hotelLikeRepository.findByHotelIdAndUser(hotelOrRoomId, user);

        if (roomType == 0) {
            byHotelIdAndUser.ifPresent(
                    m -> { throw new CustomException(ALREADY_LIKED_HOTEL);}
            );
            hotelRepository.findById(hotelOrRoomId).orElseThrow(
                    ()-> new CustomException(HOTEL_NOT_FOUND)
            );
            hotelLikeRepository.save(HotelLike.createHotelLike(user, hotelOrRoomId));
        } else if (roomType == 1) {
            roomLikeRepository.findByRoomIdAndUser(hotelOrRoomId, user).ifPresent(
                    m -> { throw new CustomException(ALREADY_LIKED_ROOM);}
            );
            Room room = roomRepository.findById(hotelOrRoomId).orElseThrow(
                    () -> new CustomException(ROOM_NOT_FOUND)
            );
            //해당 객실의 호텔을 이미 찜한 상태라면 roomlike가 hotellike를 참조할 수 있도록
            byHotelIdAndUser.ifPresentOrElse(
                            hotelLike -> roomLikeRepository.save(RoomLike.createRoomLike(hotelLike, user, hotelOrRoomId)),
                            () -> roomLikeRepository.save(RoomLike.createRoomLike(null, user, hotelOrRoomId))
                    );
        }
    }

    public User findUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                ()-> new CustomException(USER_NOT_FOUND)
        );
    }
}
