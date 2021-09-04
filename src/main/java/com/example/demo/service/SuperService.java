package com.example.demo.service;

import org.springframework.data.domain.Page;

public interface SuperService <T>{
    public T create(T t);
    public T get(String id);
    public Page<T> getAll(Integer offset, Integer limit);
    public T update(T t);
    public T delete(String id);
}
