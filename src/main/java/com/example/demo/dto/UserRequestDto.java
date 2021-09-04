package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@Builder
public class UserRequestDto implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private String userName;
    private String status;
}
