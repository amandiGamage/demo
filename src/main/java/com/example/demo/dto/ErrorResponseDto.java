package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
@Builder
public class ErrorResponseDto implements Serializable {
    private String code;
    private String message;
    private Map<String, String> errors;
}
