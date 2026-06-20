package com.moksha.developer_growth_tracker.dto;

import java.util.List;

public class InsightsResponse {

    private List<String> strengths;
    private List<String> weaknesses;
    private String recommendation;
    private Integer estimatedMonthsToNextLevel;

    public InsightsResponse(
            List<String> strengths,
            List<String> weaknesses,
            String recommendation,
            Integer estimatedMonthsToNextLevel) {

        this.strengths = strengths;
        this.weaknesses = weaknesses;
        this.recommendation = recommendation;
        this.estimatedMonthsToNextLevel =
                estimatedMonthsToNextLevel;
    }

    public List<String> getStrengths() {
        return strengths;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public Integer getEstimatedMonthsToNextLevel() {
        return estimatedMonthsToNextLevel;
    }
}