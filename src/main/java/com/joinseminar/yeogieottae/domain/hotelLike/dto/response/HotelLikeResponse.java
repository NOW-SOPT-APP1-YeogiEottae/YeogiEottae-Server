package com.joinseminar.yeogieottae.domain.hotelLike.dto.response;

import com.joinseminar.yeogieottae.domain.hotelLike.model.HotelLike;
import com.joinseminar.yeogieottae.domain.room.model.Room;
import lombok.Builder;

@Builder
public record HotelLikeResponse(
        Long hotelId,
        String hotelName,
        double reviewRate,
        RoomInformation roomInformation
) {
    @Builder
    public record RoomInformation(
            Long roomId,
            String roomName,
            String roomImage,
            int price
    ){
        public static RoomInformation of(Room room){
            return RoomInformation.builder()
                    .roomId(room.getRoomId())
                    .roomName(room.getRoomName())
                    .roomImage(room.getRoomImage())
                    .price(room.getPrice())
                    .build();
        }
    }

    public static HotelLikeResponse of(HotelLike hotelLike, Room room, String hotelName, double reviewRate){
        //객실만 추가될 경우 hotelLikeId가 null이여도 정상적으로 hotelId를 불러오도록 수정
        Long hotelId = hotelLike != null ? hotelLike.getHotelId() : room.getHotel().getHotelId();
        // roomInfo가 없는 경우 null로 보내주도록 구현
        RoomInformation roomInformation = room != null ? RoomInformation.of(room) : null;
        return HotelLikeResponse.builder()
                .hotelId(hotelId)
                .hotelName(hotelName)
                .reviewRate(reviewRate)
                .roomInformation(roomInformation)
                .build();
    }
}
