package com.moksha.developer_growth_tracker.dto;

import java.util.List;

public class DeveloperAssessmentResponse {

    private String level;
    private String developerType;

    private Integer githubScore;
    private Integer leetcodeScore;
    private Integer codeforcesScore;
    private Integer hackerrankScore;

    private Integer developerScore;

    private String nextLevel;

    private String targetRole;


    public void setSkillCoverage(Integer skillCoverage) {
        this.skillCoverage = skillCoverage;
    }

    private Integer skillCoverage;

    private List<String> missingSkills;

    public DeveloperAssessmentResponse(
            String targetRole,
            Integer skillCoverage,
            String level,
            String developerType,
            Integer githubScore,
            Integer leetcodeScore,
            Integer codeforcesScore,
            Integer hackerrankScore,
            Integer developerScore,
            String nextLevel,
            List<String> missingSkills) {

        this.targetRole = targetRole;
        this.skillCoverage = skillCoverage;
        this.level = level;
        this.developerType = developerType;
        this.githubScore = githubScore;
        this.leetcodeScore = leetcodeScore;
        this.codeforcesScore = codeforcesScore;
        this.hackerrankScore = hackerrankScore;
        this.developerScore = developerScore;
        this.nextLevel = nextLevel;
        this.missingSkills = missingSkills;
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

    public Integer getLeetcodeScore() {
        return leetcodeScore;
    }

    public Integer getCodeforcesScore() {
        return codeforcesScore;
    }

    public Integer getHackerrankScore() {
        return hackerrankScore;
    }

    public Integer getDeveloperScore() {
        return developerScore;
    }

    public String getNextLevel() {
        return nextLevel;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }
    public String getTargetRole() {
        return targetRole;
    }

    public Integer getSkillCoverage() {
        return skillCoverage;
    }
}