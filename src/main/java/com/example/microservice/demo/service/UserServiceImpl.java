package com.example.microservice.demo.service;

import com.example.microservice.demo.mapper.UserMapper;
import com.example.microservice.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "UserCache")
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @CacheEvict(value = "UserCache",allEntries = true)
    @Override
    public void saveOne(User user) {
        userMapper.saveOne(user);
    }

    @CacheEvict(value = "UserCache",allEntries = true)
    @Override
    public void update(User user) {
        userMapper.update(user);
    }


    @CacheEvict(value = "UserCache",allEntries = true)
    @Override
    public void deleteOneById(long id) {
        userMapper.deleteOneById(id);
    }

}
