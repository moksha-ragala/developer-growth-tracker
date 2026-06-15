package com.moksha.developer_growth_tracker.service;

import com.moksha.developer_growth_tracker.dto.DeveloperAssessmentResponse;
import com.moksha.developer_growth_tracker.entity.User;
import com.moksha.developer_growth_tracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    private final UserRepository userRepository;
    private final SkillMatrixService skillMatrixService;

    public AssessmentService(
            UserRepository userRepository,
            SkillMatrixService skillMatrixService) {

        this.userRepository = userRepository;
        this.skillMatrixService = skillMatrixService;
    }

    public DeveloperAssessmentResponse assess(
            String email) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow();

        String role = user.getTargetRole();

        List<String> requiredSkills =
                skillMatrixService.getRequiredSkills(role);

        List<String> currentSkills = List.of(
                "Java",
                "Spring Boot",
                "MySQL"
        );

        List<String> missingSkills =
                new java.util.ArrayList<>(requiredSkills);

        missingSkills.removeAll(currentSkills);

        int skillCoverage =
                (currentSkills.size() * 100)
                        / requiredSkills.size();

        int githubScore = 80;
        int leetcodeScore = 40;
        int codeforcesScore = 30;
        int hackerrankScore = 50;

        int developerScore =
                (githubScore +
                        leetcodeScore +
                        codeforcesScore +
                        hackerrankScore) / 4;

        String level;
        String nextLevel;

        if (skillCoverage < 40) {
            level = "Beginner";
            nextLevel = "Intermediate";
        } else if (skillCoverage < 75) {
            level = "Intermediate";
            nextLevel = "Advanced";
        } else {
            level = "Advanced";
            nextLevel = "Expert";
        }

        String developerType =
                "Java Full Stack Builder";

        return new DeveloperAssessmentResponse(
                role,
                skillCoverage,
                level,
                developerType,
                githubScore,
                leetcodeScore,
                codeforcesScore,
                hackerrankScore,
                developerScore,
                nextLevel,
                missingSkills
        );
    }
}