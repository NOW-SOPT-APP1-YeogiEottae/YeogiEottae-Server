package com.joinseminar.yeogieottae.domain.hotelLike.service;

import com.joinseminar.yeogieottae.domain.hotelLike.dto.response.HotelLikeResponse;

import java.util.List;

public interface HotelLikeService {
    List<HotelLikeResponse> getLikes(Long userId);
}
