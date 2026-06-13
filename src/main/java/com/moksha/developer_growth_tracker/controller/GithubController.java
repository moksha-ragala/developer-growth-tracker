package com.moksha.developer_growth_tracker.controller;

import com.moksha.developer_growth_tracker.dto.GithubAnalyticsResponse;
import com.moksha.developer_growth_tracker.dto.GithubProfileResponse;
import com.moksha.developer_growth_tracker.service.GithubService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/github")
public class GithubController {

    private final GithubService githubService;

    public GithubController(
            GithubService githubService) {

        this.githubService = githubService;
    }

    @GetMapping("/{username}")
    public GithubProfileResponse getProfile(
            @PathVariable String username) {

        return githubService
                .getGithubProfile(username);
    }

    @GetMapping("/analytics/{username}")
    public GithubAnalyticsResponse analytics(
            @PathVariable String username) {

        return githubService.getAnalytics(
                username
        );
    }
}