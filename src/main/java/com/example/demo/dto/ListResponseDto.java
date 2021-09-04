package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ListResponseDto<T> {
    private int totalPage;
    private long totalElements;
    private int size;
    private int numberOfElements;
    private int offset;
    private List<T> data;
}
