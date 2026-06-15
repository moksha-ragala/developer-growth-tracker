package com.moksha.developer_growth_tracker.dto;

import java.util.List;

public class RoadmapResponse {

    private String targetRole;
    private String currentLevel;
    private String nextLevel;
    private List<String> roadmap;

    public RoadmapResponse(
            String targetRole,
            String currentLevel,
            String nextLevel,
            List<String> roadmap) {

        this.targetRole = targetRole;
        this.currentLevel = currentLevel;
        this.nextLevel = nextLevel;
        this.roadmap = roadmap;
    }

    public String getTargetRole() {
        return targetRole;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public String getNextLevel() {
        return nextLevel;
    }

    public List<String> getRoadmap() {
        return roadmap;
    }
}