package com.example.microservice.demo.controller;

import com.example.microservice.demo.model.CommonAPIResponse;
import com.example.microservice.demo.model.User;
import com.example.microservice.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public CommonAPIResponse<List<User>> findAll() {
        List<User> users = userService.findAll();
        CommonAPIResponse<List<User>> response = new CommonAPIResponse<>();
        response.setData(users);
        return response;
    }

    @PostMapping("/")
    public void saveOne(@RequestBody User user) {
        userService.saveOne(user);
    }

    @PostMapping("/{id}")
    public void update(@PathVariable long id,@RequestBody User user) {
        user.setId(id);
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.deleteOneById(id);
    }
}
