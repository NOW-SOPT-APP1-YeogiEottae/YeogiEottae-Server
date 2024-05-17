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
        // roomInfo가 없는 경우 null로 보내주도록 구현
        RoomInformation roomInformation = room != null ? RoomInformation.of(room) : null;
        return HotelLikeResponse.builder()
                .hotelId(hotelLike.getHotelId())
                .hotelName(hotelName)
                .reviewRate(reviewRate)
                .roomInformation(roomInformation)
                .build();
    }
}
