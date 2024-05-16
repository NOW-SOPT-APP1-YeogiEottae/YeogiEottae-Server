package com.joinseminar.yeogieottae.domain.roomLike.dto;

import jakarta.validation.constraints.NotNull;

public record DeleteHotelOrRoomLikeRequest(

        @NotNull
        Long id
) {
}
