package com.moksha.developer_growth_tracker.service;

import com.moksha.developer_growth_tracker.dto.DeveloperAssessmentResponse;
import com.moksha.developer_growth_tracker.dto.LeetcodeStatsResponse;
import com.moksha.developer_growth_tracker.entity.ProgressHistory;
import com.moksha.developer_growth_tracker.entity.User;
import com.moksha.developer_growth_tracker.repository.ProgressHistoryRepository;
import com.moksha.developer_growth_tracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssessmentService {

    private final UserRepository userRepository;
    private final SkillMatrixService skillMatrixService;
    private final CodeforcesService codeforcesService;
    private final GithubService githubService;
    private final LeetcodeService leetcodeService;
    private final ProgressHistoryRepository progressHistoryRepository;

    public AssessmentService(
            UserRepository userRepository,
            SkillMatrixService skillMatrixService,
            CodeforcesService codeforcesService,
            GithubService githubService,
            LeetcodeService leetcodeService,
            ProgressHistoryRepository progressHistoryRepository) {

        this.userRepository = userRepository;
        this.skillMatrixService = skillMatrixService;
        this.codeforcesService = codeforcesService;
        this.githubService = githubService;
        this.leetcodeService = leetcodeService;
        this.progressHistoryRepository = progressHistoryRepository;
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

        int githubScore = 0;

        if (user.getGithubUsername() != null &&
                !user.getGithubUsername().isBlank()) {

            githubScore =
                    githubService.calculateGithubScore(
                            user.getGithubUsername()
                    );
        }

        int leetcodeScore = 0;

        try {

            if (user.getLeetcodeUsername() != null &&
                    !user.getLeetcodeUsername().isBlank()) {

                LeetcodeStatsResponse stats =
                        leetcodeService.getStats(
                                user.getLeetcodeUsername()
                        );

                leetcodeScore =
                        leetcodeService.calculateScore(
                                stats
                        );
            }

        } catch (Exception e) {

            System.out.println(
                    "LeetCode profile unavailable"
            );
        }

        int hackerrankScore = 50;

        int codeforcesScore = 0;

        try {

            if (user.getCodeforcesHandle() != null &&
                    !user.getCodeforcesHandle().isBlank()) {

                codeforcesScore =
                        codeforcesService.calculateScore(
                                user.getCodeforcesHandle()
                        );
            }

        } catch (Exception e) {

            System.out.println(
                    "Codeforces profile unavailable"
            );
        }

        int total =
                githubScore +
                        leetcodeScore +
                        codeforcesScore;

        int sources = 0;

        if (githubScore > 0) {
            sources++;
        }

        if (leetcodeScore > 0) {
            sources++;
        }

        if (codeforcesScore > 0) {
            sources++;
        }

        int developerScore =
                sources > 0
                        ? total / sources
                        : 0;

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

        String developerType;

        if (githubScore >= 70 &&
                leetcodeScore >= 70) {

            developerType =
                    "Full Stack Problem Solver";

        } else if (leetcodeScore >= 70) {

            developerType =
                    "DSA Specialist";

        } else if (githubScore >= 70) {

            developerType =
                    "Project Builder";

        } else {

            developerType =
                    "Java Full Stack Builder";
        }

        ProgressHistory history =
                new ProgressHistory();

        history.setEmail(email);

        history.setDeveloperScore(
                developerScore
        );

        history.setCreatedAt(
                LocalDateTime.now()
        );

        progressHistoryRepository.save(
                history
        );

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