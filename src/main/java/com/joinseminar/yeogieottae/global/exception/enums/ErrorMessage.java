package com.joinseminar.yeogieottae.global.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    LIKES_NOT_FOUND_BY_ID_EXCEPTION(404, "찜 목록 리스트에 해당 ID가 없습니다."),
    INVALID_VALUE(400, "잘못된 입력값입니다.")

    ;
    private final int status;
    private final String message;
}
