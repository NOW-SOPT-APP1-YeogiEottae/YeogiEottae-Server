package com.joinseminar.yeogieottae.domain.hotelLike.model;

import com.joinseminar.yeogieottae.domain.roomLike.model.RoomLike;
import com.joinseminar.yeogieottae.domain.user.model.User;
import com.joinseminar.yeogieottae.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class HotelLike extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelLikeId; // 호텔 찜 목록 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user; // 유저 ID

    private Long hotelId; // 호텔 ID

    @OneToMany(mappedBy = "hotelLike", cascade = CascadeType.ALL)
    private List<RoomLike> roomLikeList = new ArrayList<>();
}
