package com.joinseminar.yeogieottae.global.exception.model;

import com.joinseminar.yeogieottae.global.exception.enums.ErrorMessage;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private ErrorMessage errorMessage;

    public CustomException(ErrorMessage errorMessage){
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
