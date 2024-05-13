package com.joinseminar.yeogieottae.domain.user.model;

import com.joinseminar.yeogieottae.domain.hotelLike.model.HotelLike;
import com.joinseminar.yeogieottae.domain.roomLike.model.RoomLike;
import com.joinseminar.yeogieottae.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; // 유저 ID

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<HotelLike> hotelLIkeList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<RoomLike> roomLikeList = new ArrayList<>();

}
