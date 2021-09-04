package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserResponseDto implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private String userName;
    private String status;
}
