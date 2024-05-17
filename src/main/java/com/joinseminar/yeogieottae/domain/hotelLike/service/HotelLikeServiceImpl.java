package com.joinseminar.yeogieottae.domain.hotelLike.service;

import com.joinseminar.yeogieottae.domain.hotel.model.Hotel;
import com.joinseminar.yeogieottae.domain.hotel.repository.HotelRepository;
import com.joinseminar.yeogieottae.domain.hotelLike.dto.response.HotelLikeResponse;
import com.joinseminar.yeogieottae.domain.hotelLike.model.HotelLike;
import com.joinseminar.yeogieottae.domain.hotelLike.repository.HotelLikeRepository;
import com.joinseminar.yeogieottae.domain.room.model.Room;
import com.joinseminar.yeogieottae.domain.room.repository.RoomRepository;
import com.joinseminar.yeogieottae.domain.roomLike.model.RoomLike;
import com.joinseminar.yeogieottae.domain.roomLike.repository.RoomLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HotelLikeServiceImpl implements HotelLikeService {

    private final HotelLikeRepository hotelLikeRepository;
    private final RoomLikeRepository roomLikeRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    @Override
    public List<HotelLikeResponse> getLikes(Long userId){
        //userId로 호텔 찜 목록 조회하기
        List<HotelLike> hotelLikes = hotelLikeRepository.findAllByUserId(userId);

        //HotelLike 목록에서 호텔 ID 추출하기 -> 호텔 ID로 호텔 정보 조회하고, Map로 저장하기
        List<Long> hotelIds = hotelLikes.stream()
                .map(HotelLike::getHotelId)
                .collect(Collectors.toList());
        Map<Long, Hotel> hotelMap = hotelRepository.findAllById(hotelIds).stream()
                .collect(Collectors.toMap(Hotel::getHotelId, hotel -> hotel));

        //userId로 객실 찜 목록 조회하기
        List<RoomLike> roomLikes = roomLikeRepository.findAllByUserId(userId);

        //RoomLike 목록에서 객실 ID 추출하기 -> 객실 ID로 호텔 정보 조회하고, Map로 저장하기
        List<Long> roomIds = roomLikes.stream()
                .map(RoomLike::getRoomId)
                .collect(Collectors.toList());
        Map<Long, Room> roomMap = roomRepository.findAllById(roomIds).stream()
                .collect(Collectors.toMap(Room::getRoomId, room -> room));

        //호텔 찜 정보를 순회하면서 LikeResponse 생성하기
        return hotelLikes.stream()
                .map(hotelLike -> {
                    Hotel hotel = hotelMap.get(hotelLike.getHotelId());

                    //RoomLike 목록에서 HotelLike에 해당하는 객실만 가져오기
                    List<Room> rooms = roomLikes.stream()
                            .filter(roomLike -> {
                                HotelLike hl = roomLike.getHotelLike();
                                return hl != null && hl.getHotelLikeId().equals(hotelLike.getHotelLikeId());
                            })
                            .map(roomLike -> roomMap.get(roomLike.getRoomId()))
                            .collect(Collectors.toList());

                    if (rooms.isEmpty()) {
                        // 호텔만 좋아요한 경우
                        return List.of(HotelLikeResponse.of(hotelLike, null, hotel.getHotelName(), hotel.getReviewRate()));
                    } else {
                        // 호텔과 방을 모두 좋아요한 경우
                        return rooms.stream()
                                .map(room -> HotelLikeResponse.of(hotelLike, room, hotel.getHotelName(), hotel.getReviewRate()))
                                .collect(Collectors.toList());
                    }
                })
                .flatMap(List::stream) // Map -> List 형태로 반환하기 위해 사용
                .collect(Collectors.toList());
    }
}
