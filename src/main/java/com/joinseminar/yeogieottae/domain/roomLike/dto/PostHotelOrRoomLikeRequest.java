package com.joinseminar.yeogieottae.domain.roomLike.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

public record PostHotelOrRoomLikeRequest(
        @NotNull(message = "id는 필수 값입니다.")
        Long id
) {
}
