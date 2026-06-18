package com.moksha.developer_growth_tracker.dto;

import java.util.List;

public class DashboardResponse {

    private String name;
    private String targetRole;

    private Integer developerScore;
    private String level;
    private String developerType;

    private Integer githubScore;
    private Integer codeforcesScore;

    private Integer skillCoverage;

    private List<String> missingSkills;
    private List<String> roadmap;

    public DashboardResponse(
            String name,
            String targetRole,
            Integer developerScore,
            String level,
            String developerType,
            Integer githubScore,
            Integer codeforcesScore,
            Integer skillCoverage,
            List<String> missingSkills,
            List<String> roadmap) {

        this.name = name;
        this.targetRole = targetRole;
        this.developerScore = developerScore;
        this.level = level;
        this.developerType = developerType;
        this.githubScore = githubScore;
        this.codeforcesScore = codeforcesScore;
        this.skillCoverage = skillCoverage;
        this.missingSkills = missingSkills;
        this.roadmap = roadmap;
    }

    public String getName() {
        return name;
    }

    public String getTargetRole() {
        return targetRole;
    }

    public Integer getDeveloperScore() {
        return developerScore;
    }

    public String getLevel() {
        return level;
    }

    public String getDeveloperType() {
        return developerType;
    }

    public Integer getGithubScore() {
        return githubScore;
    }

    public Integer getCodeforcesScore() {
        return codeforcesScore;
    }

    public Integer getSkillCoverage() {
        return skillCoverage;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public List<String> getRoadmap() {
        return roadmap;
    }
}