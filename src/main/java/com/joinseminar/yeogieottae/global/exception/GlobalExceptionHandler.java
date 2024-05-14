package com.joinseminar.yeogieottae.global.exception;

import com.joinseminar.yeogieottae.global.common.dto.ErrorResponse;
import com.joinseminar.yeogieottae.global.exception.enums.ErrorMessage;
import com.joinseminar.yeogieottae.global.exception.model.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        return ResponseEntity
                .badRequest()
                .body(ErrorResponse.of(
                        e.getErrorMessage().getStatus(),
                        e.getErrorMessage().getMessage())
                );
    }







//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public  ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//
//        ErrorMessage errorCode = ErrorCode.INVALID_VALUE;
//        return ResponseEntity.status(errorCode.getHttpStatus())
//                .body(ErrorResponse.of(
//                        errorCode.getHttpStatus(),
//                        errorCode.getMessage(),
//                        e.getBindingResult()
//                ));
//    }
}
