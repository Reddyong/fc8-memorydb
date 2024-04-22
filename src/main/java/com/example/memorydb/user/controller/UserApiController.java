package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/user")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;
    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity userEntity) {
        return userService.save(userEntity);
    }

    @GetMapping(path = "/all")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/id/{userId}")
    public UserEntity findById(@PathVariable(name = "userId") Long id) {
        var response = userService.findById(id);
        return response.get();
    }

    @GetMapping(path = "/score")
    public List<UserEntity> findAllScoreGreaterThan(@RequestParam int score) {
        return userService.findAllScoreGreaterThan(score);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public void delete(@PathVariable(name = "userId") Long id) {
        userService.delete(id);
    }
}
