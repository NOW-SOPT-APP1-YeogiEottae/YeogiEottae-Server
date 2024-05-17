package com.joinseminar.yeogieottae.domain.hotelLike.model;

import com.joinseminar.yeogieottae.domain.roomLike.model.RoomLike;
import com.joinseminar.yeogieottae.domain.user.model.User;
import com.joinseminar.yeogieottae.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HotelLike extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelLikeId; // 호텔 찜 목록 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user; // 유저 ID

    private Long hotelId; // 호텔 ID

    @OneToMany(mappedBy = "hotelLike")
    private List<RoomLike> roomLikeList = new ArrayList<>();

    @Builder(access = PRIVATE)
    private HotelLike(final User user, final Long hotelId)
    {
        this.user = user;
        this.hotelId = hotelId;
    }

    // 생성 메서드 정의
    public static HotelLike createHotelLike(final User user, final Long hotelId)
    {
        return HotelLike.builder()
                .user(user)
                .hotelId(hotelId)
                .build();
    }
}
