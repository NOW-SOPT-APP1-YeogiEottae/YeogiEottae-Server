package com.joinseminar.yeogieottae.global.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    LIKES_NOT_FOUND_BY_ID_EXCEPTION(404, "찜 목록 리스트에 해당 ID가 없습니다."),
    INVALID_VALUE(400, "잘못된 입력값입니다."),
    HOTEL_NOT_FOUND(404, "ID에 해당하는 호텔이 없습니다."),
    COMPARE_ROOM_LIMIT_EXCEEDED(400, "비교하기 목록에는 최대 5개의 항목만 추가할 수 있습니다."),
    ROOM_NOT_FOUND(404, "ID에 해당하는 방이 없습니다."),
    USER_NOT_FOUND(404, "ID에 해당하는 유저가 없습니다."),
    ALREADY_LIKED_HOTEL(400, "이미 찜한 호텔입니다."),
    ALREADY_LIKED_ROOM(400, "이미 찜한 객실입니다."),
    ;
    private final int status;
    private final String message;
}
