package com.example.memorydb.user.service;

import com.example.memorydb.user.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity save(UserEntity user) {
        // save
        return userRepository.save(user);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<UserEntity> findAllByScoreGreaterThan(int score) {
        return userRepository.findAllByScoreGreaterThan(score);
    }

    public List<UserEntity> findByScore(int min, int max) {
        return userRepository.findByScore(min, max);
    }

    public List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int firstScore, int lastScore) {
        return userRepository.findAllByScoreGreaterThanEqualAndScoreLessThanEqual(firstScore, lastScore);
    }

    public void delete(UserEntity user) {
        userRepository.delete(user);
    }
}
