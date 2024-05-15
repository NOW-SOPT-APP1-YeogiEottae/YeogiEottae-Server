package com.joinseminar.yeogieottae.global.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SuccessMessage {

    ADD_COMPARE_TO_LIST_BY_ID(200, true, "비교하기 목록에 찜 목록이 추가되었습니다."),
    GET_HOTEL_DETAIL_SUCCESS(200, true, "호텔 상세 조회 API 요청 성공")
    ;
    private final int status;
    private final boolean success;
    private final String message;
}