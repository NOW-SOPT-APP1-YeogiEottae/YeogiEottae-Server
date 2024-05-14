package com.joinseminar.yeogieottae.global.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.joinseminar.yeogieottae.global.exception.enums.SuccessMessage;

@JsonPropertyOrder({"code", "success", "message", "data"})
public record SuccessResponse<T> (
        int code,
        boolean success,

        String message,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        T data
) {
    public static <T> SuccessResponse of(SuccessMessage successMessage){
        return new SuccessResponse(successMessage.getStatus(), successMessage.isSuccess(), successMessage.getMessage(), null);
    }

    public static <T> SuccessResponse of(SuccessMessage successMessage, T data){
        return new SuccessResponse(successMessage.getStatus(), successMessage.isSuccess(), successMessage.getMessage(), data);
    }
}
