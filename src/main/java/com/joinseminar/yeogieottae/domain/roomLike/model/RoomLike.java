package com.joinseminar.yeogieottae.domain.roomLike.model;

import com.joinseminar.yeogieottae.domain.hotelLike.model.HotelLike;
import com.joinseminar.yeogieottae.domain.user.model.User;
import com.joinseminar.yeogieottae.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomLike extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomLikeId; // 객실 찜 목록 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelLikeId")
    private HotelLike hotelLike; // 호텔 찜 목록 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user; // 유저 ID

    private Long roomId; // 객실 ID

    private boolean isCompared; // 비교하기 목록 추가 여부

    @Builder
    private RoomLike(final HotelLike hotelLike, final User user, final Long roomId, final boolean isCompared)
    {
        this.hotelLike = hotelLike;
        this.user = user;
        this.roomId = roomId;
        this.isCompared = isCompared;
    }

    public static RoomLike createRoomLike(final HotelLike hotelLike, final User user, final Long roomId)
    {
        return RoomLike.builder()
                .hotelLike(hotelLike)
                .user(user)
                .roomId(roomId)
                .isCompared(false)
                .build();
    }
}
