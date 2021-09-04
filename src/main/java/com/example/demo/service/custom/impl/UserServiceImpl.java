package com.example.demo.service.custom.impl;

import com.example.demo.exception.SystemException;
import com.example.demo.model.QUser;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.custom.UserService;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        Optional<User> findUser = findByUserName(user.getUserName());
        if (findUser.isPresent()){
            throw new SystemException(String.format("user already exist for username %s", user.getUserName()));
        } else {
            User createdUser = userRepository.save(user);
            log.info("user has been created {}", createdUser);
            return createdUser;
        }
    }

    @Override
    public User get(String id) {
        QUser quser = QUser.user;
        BooleanExpression expression = quser.id.eq(id);
        Optional<User> one = userRepository.findOne(expression);
        if (one.isPresent()){
            return one.get();
        }else {
            throw new SystemException(String.format("user not found by id: %s", id));
        }
    }

    @Override
    public Page<User> getAll(Integer offset, Integer limit) {
        PageRequest pageRequest = PageRequest.of(offset, limit);
        return userRepository.findAll(pageRequest);
    }

    @Override
    public User update(User user) {
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @Override
    public User delete(String id) {
        QUser qUser = QUser.user;
        BooleanExpression booleanExpression = qUser.id.eq(id);
        Optional<User> one = userRepository.findOne(booleanExpression);
        if (one.isPresent()){
            one.get().setStatus("DEACTIVE");
            User deactivatedUser = userRepository.save(one.get());
            return deactivatedUser;
        }else {
            throw new SystemException(String.format("user delete failed %s",id));
        }
    }

    @Override
    public Optional<User> findByUserName(String username) {
        QUser qUser = QUser.user;
        BooleanExpression booleanExpression = qUser.userName.eq(username);
        return userRepository.findOne(booleanExpression);
    }
}
