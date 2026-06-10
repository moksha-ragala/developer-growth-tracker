package com.moksha.developer_growth_tracker.controller;

import com.moksha.developer_growth_tracker.dto.RegisterRequest;
import com.moksha.developer_growth_tracker.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.moksha.developer_growth_tracker.dto.LoginRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}