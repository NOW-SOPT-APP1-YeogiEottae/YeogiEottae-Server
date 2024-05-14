package com.joinseminar.yeogieottae.global.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SuccessMessage {

    ADD_COMPARE_TO_LIST_BY_ID(200, true, "비교하기 목록에 찜 목록이 추가되었습니다."),
    ;
    private final int status;
    private final boolean success;
    private final String message;
}
