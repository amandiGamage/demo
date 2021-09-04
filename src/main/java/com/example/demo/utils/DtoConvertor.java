package com.example.demo.utils;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class DtoConvertor {
    public static User userRequestDtoToUser(UserRequestDto userRequestDto){
        return User.builder()
                .id(userRequestDto.getId())
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .email(userRequestDto.getEmail())
                .contactNo(userRequestDto.getContactNo())
                .userName(userRequestDto.getUserName())
                .status(userRequestDto.getStatus())
                .build();
    }

    public static UserResponseDto userToUserResponseDto(User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .contactNo(user.getContactNo())
                .userName(user.getUserName())
                .status(user.getStatus())
                .build();
    }

    public static List<UserResponseDto> userListToUserResponseList(List<User> users){
       List<UserResponseDto> userResponseDtoList = new ArrayList<>();

        for (User user :users) {
            userResponseDtoList.add(userToUserResponseDto(user));
        }

        return userResponseDtoList;
    }
}
