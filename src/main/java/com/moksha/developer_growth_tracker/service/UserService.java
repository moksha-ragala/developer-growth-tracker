package com.moksha.developer_growth_tracker.service;

import com.moksha.developer_growth_tracker.dto.RegisterRequest;
import com.moksha.developer_growth_tracker.entity.User;
import com.moksha.developer_growth_tracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public String register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already exists";
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setGithubUsername(request.getGithubUsername());
        user.setLeetcodeUsername(request.getLeetcodeUsername());
        user.setTargetRole(request.getTargetRole());
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        return "User registered successfully";
    }
}