package com.moksha.developer_growth_tracker.dto;

public class ProfileResponse {

    private String name;
    private String email;
    private String githubUsername;
    private String leetcodeUsername;
    private String targetRole;

    public ProfileResponse(String name,
                           String email,
                           String githubUsername,
                           String leetcodeUsername,
                           String targetRole) {

        this.name = name;
        this.email = email;
        this.githubUsername = githubUsername;
        this.leetcodeUsername = leetcodeUsername;
        this.targetRole = targetRole;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGithubUsername() {
        return githubUsername;
    }

    public String getLeetcodeUsername() {
        return leetcodeUsername;
    }

    public String getTargetRole() {
        return targetRole;
    }
}