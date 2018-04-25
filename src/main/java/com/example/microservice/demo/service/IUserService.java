package com.example.microservice.demo.service;

import com.example.microservice.demo.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    void saveOne(User user);
    void update(User user);
    void deleteOneById(long id);
}
