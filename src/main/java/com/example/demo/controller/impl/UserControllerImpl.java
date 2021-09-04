package com.example.demo.controller.impl;

import com.example.demo.controller.UserController;
import com.example.demo.dto.ListResponseDto;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.model.User;
import com.example.demo.service.custom.UserService;
import com.example.demo.utils.DtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = DtoConvertor.userRequestDtoToUser(userRequestDto);
        UUID uuid = UUID.randomUUID();
        user.setId(uuid.toString());
        User createdUser = userService.create(user);
        return DtoConvertor.userToUserResponseDto(createdUser);
    }

    @Override
    public ListResponseDto<UserResponseDto> getAllUsers(Integer offset, Integer limit) {
        Page<User> allUsers = userService.getAll(offset, limit);
        return ListResponseDto.<UserResponseDto>builder()
                .data(DtoConvertor.userListToUserResponseList(allUsers.getContent()))
                .numberOfElements(allUsers.getNumberOfElements())
                .offset(offset)
                .size(allUsers.getSize())
                .totalElements(allUsers.getTotalElements())
                .totalPage(allUsers.getTotalPages())
                .build();
    }

    @Override
    public UserResponseDto getUser(Integer id) {
        return DtoConvertor.userToUserResponseDto(userService.get(id.toString()));
    }

    @Override
    public UserResponseDto updateUser(Integer id, UserRequestDto userRequestDto) {
        User user = DtoConvertor.userRequestDtoToUser(userRequestDto);
        return DtoConvertor.userToUserResponseDto(userService.update(user));
    }

    @Override
    public UserResponseDto deleteUser(Integer id) {
        return DtoConvertor.userToUserResponseDto(userService.delete(id.toString()));
    }
}
