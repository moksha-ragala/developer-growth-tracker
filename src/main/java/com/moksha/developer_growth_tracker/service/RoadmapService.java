package com.moksha.developer_growth_tracker.service;

import com.moksha.developer_growth_tracker.dto.DeveloperAssessmentResponse;
import com.moksha.developer_growth_tracker.dto.RoadmapResponse;
import org.springframework.stereotype.Service;

@Service
public class RoadmapService {

    private final AssessmentService assessmentService;

    public RoadmapService(
            AssessmentService assessmentService) {

        this.assessmentService = assessmentService;
    }

    public RoadmapResponse generateRoadmap(
            String email) {

        DeveloperAssessmentResponse assessment =
                assessmentService.assess(email);

        return new RoadmapResponse(
                assessment.getTargetRole(),
                assessment.getLevel(),
                assessment.getNextLevel(),
                assessment.getMissingSkills()
        );
    }
}