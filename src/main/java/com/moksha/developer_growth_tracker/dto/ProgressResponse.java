package com.moksha.developer_growth_tracker.dto;

public class ProgressResponse {

    private String email;
    private Integer currentScore;
    private Integer previousScore;
    private Integer growth;
    private String status;

    public ProgressResponse(
            String email,
            Integer currentScore,
            Integer previousScore,
            Integer growth,
            String status) {

        this.email = email;
        this.currentScore = currentScore;
        this.previousScore = previousScore;
        this.growth = growth;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public Integer getCurrentScore() {
        return currentScore;
    }

    public Integer getPreviousScore() {
        return previousScore;
    }

    public Integer getGrowth() {
        return growth;
    }

    public String getStatus() {
        return status;
    }
}