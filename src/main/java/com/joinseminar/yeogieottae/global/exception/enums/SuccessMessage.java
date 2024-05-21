package com.joinseminar.yeogieottae.global.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SuccessMessage {

    ADD_COMPARE_TO_LIST_BY_ID(200, true, "비교하기 목록에 찜 목록이 추가되었습니다."),
    GET_HOTEL_DETAIL_SUCCESS(200, true, "호텔 상세 조회 API 요청 성공"),
    GET_LIKED_ROOM_NOT_IN_COMPARE_SUCCESS(200, true, "비교하기 > 내가 찜한 목록 조회 API 요청 성공"),
    GET_COMPARE_TO_LIST_BY_ID(200, true, "비교하기 목록 불러오기를 성공했습니다."),
    POST_LIKE_SUCCESS(201, true, "찜 추가 요청 성공"),
    DELETE_LIKE_SUCCESS(200, true, "찜 삭제 성공"),
    GET_LIKES_SUCCESS(200, true, "찜 목록 정보 불러오기를 성공했습니다."),
    DELETE_COMPARE_LIKE_SUCCESS(200, true, "비교하기 목록에서 찜 목록 삭제를 성공했습니다."),
    ;
  
    private final int status;
    private final boolean success;
    private final String message;
}
