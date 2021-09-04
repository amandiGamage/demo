package com.example.demo.advisor;

import com.example.demo.dto.ErrorResponseDto;
import com.example.demo.exception.SystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler({
            SystemException.class,
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponseDto> systemException(SystemException ex) {
        return new ResponseEntity<>(ErrorResponseDto.builder()
                .code(ex.getErrorCode())
                .message(ex.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }
}