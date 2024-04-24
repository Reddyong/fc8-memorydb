package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<UserEntity> findAllByScoreGreaterThan(@RequestParam int score) {
        return userService.findAllByScoreGreaterThan(score);
    }

    @GetMapping(path = "/score-between")
    public List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(
            @RequestParam(name = "first-score") int firstScore,
            @RequestParam(name = "last-score") int lastScore) {
        return userService.findAllByScoreGreaterThanEqualAndScoreLessThanEqual(firstScore, lastScore);
    }

    @GetMapping(path = "/score-query")
    public List<UserEntity> findByScore(
            @RequestParam(name = "min") int firstScore,
            @RequestParam(name = "max") int lastScore) {
        return userService.findByScore(firstScore, lastScore);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public void delete(@PathVariable(name = "userId") UserEntity user) {
        userService.delete(user);
    }
}
