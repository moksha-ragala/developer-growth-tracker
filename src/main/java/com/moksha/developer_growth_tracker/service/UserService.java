package com.moksha.developer_growth_tracker.service;

import com.moksha.developer_growth_tracker.dto.ProfileResponse;
import com.moksha.developer_growth_tracker.dto.RegisterRequest;
import com.moksha.developer_growth_tracker.entity.User;
import com.moksha.developer_growth_tracker.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.moksha.developer_growth_tracker.dto.LoginRequest;

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

    public String login(LoginRequest request) {

        Optional<User> optionalUser =
                userRepository.findByEmail(request.getEmail());

        if (optionalUser.isEmpty()) {
            return "User not found";
        }

        User user = optionalUser.get();

        boolean matches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if (!matches) {
            return "Invalid password";
        }

        return "Login successful";
    }

    public ProfileResponse getProfile(String email) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow();

        return new ProfileResponse(
                user.getName(),
                user.getEmail(),
                user.getGithubUsername(),
                user.getLeetcodeUsername(),
                user.getTargetRole()
        );
    }
}