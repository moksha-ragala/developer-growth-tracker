package com.moksha.developer_growth_tracker.service;

import com.moksha.developer_growth_tracker.dto.DeveloperAssessmentResponse;
import com.moksha.developer_growth_tracker.dto.InsightsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsightsService {

    private final AssessmentService assessmentService;

    public InsightsService(
            AssessmentService assessmentService) {

        this.assessmentService = assessmentService;
    }

    public InsightsResponse getInsights(
            String email) {

        DeveloperAssessmentResponse assessment =
                assessmentService.assess(email);

        List<String> strengths = List.of(
                "Java",
                "Spring Boot",
                "MySQL"
        );

        List<String> weaknesses =
                assessment.getMissingSkills();

        String recommendation;

        if (weaknesses.size() >= 2) {

            recommendation =
                    "Focus on "
                            + weaknesses.get(0)
                            + " and "
                            + weaknesses.get(1)
                            + " to reach "
                            + assessment.getNextLevel();

        } else {

            recommendation =
                    "Continue improving your skills";
        }

        int estimatedMonthsToNextLevel = 3;

        return new InsightsResponse(
                strengths,
                weaknesses,
                recommendation,
                estimatedMonthsToNextLevel
        );
    }
}