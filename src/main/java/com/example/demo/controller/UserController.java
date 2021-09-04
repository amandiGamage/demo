package com.example.demo.controller;

import com.example.demo.dto.ListResponseDto;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;


public interface UserController {
    @PostMapping(path = "/users")
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto);

    @GetMapping(path = "/users")
    public ListResponseDto<UserResponseDto> getAllUsers(@RequestParam("offset")Integer offset,
                                                       @RequestParam("limit")Integer limit);

    @GetMapping(value = "/users/{id}")
    public UserResponseDto getUser(@PathVariable("id")Integer id);

    @PutMapping(value = "/users/{id}")
    public UserResponseDto updateUser(@PathVariable("id")Integer id,
                                      @RequestBody UserRequestDto userRequestDto);

    @DeleteMapping(value = "/users/{id}")
    public UserResponseDto deleteUser(@PathVariable("id")Integer id);
}
