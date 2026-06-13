package com.moksha.developer_growth_tracker.dto;

public class GithubAnalyticsResponse {

    private String username;
    private Integer followers;
    private Integer publicRepos;
    private Integer totalCommits;
    private Integer developerScore;

    public GithubAnalyticsResponse(
            String username,
            Integer followers,
            Integer publicRepos,
            Integer totalCommits,
            Integer developerScore) {

        this.username = username;
        this.followers = followers;
        this.publicRepos = publicRepos;
        this.totalCommits = totalCommits;
        this.developerScore = developerScore;
    }

    public String getUsername() {
        return username;
    }

    public Integer getFollowers() {
        return followers;
    }

    public Integer getPublicRepos() {
        return publicRepos;
    }

    public Integer getTotalCommits() {
        return totalCommits;
    }

    public Integer getDeveloperScore() {
        return developerScore;
    }

}