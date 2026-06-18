package com.moksha.developer_growth_tracker.service;

import com.moksha.developer_growth_tracker.dto.*;
import com.moksha.developer_growth_tracker.entity.User;
import com.moksha.developer_growth_tracker.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final UserRepository userRepository;
    private final AssessmentService assessmentService;
    private final RoadmapService roadmapService;

    public DashboardService(
            UserRepository userRepository,
            AssessmentService assessmentService,
            RoadmapService roadmapService) {

        this.userRepository = userRepository;
        this.assessmentService = assessmentService;
        this.roadmapService = roadmapService;
    }

    public DashboardResponse getDashboard(
            String email) {

        User user =
                userRepository.findByEmail(email)
                        .orElseThrow();

        DeveloperAssessmentResponse assessment =
                assessmentService.assess(email);

        RoadmapResponse roadmap =
                roadmapService.generateRoadmap(email);

        return new DashboardResponse(
                user.getName(),
                user.getTargetRole(),
                assessment.getDeveloperScore(),
                assessment.getLevel(),
                assessment.getDeveloperType(),
                assessment.getGithubScore(),
                assessment.getCodeforcesScore(),
                assessment.getSkillCoverage(),
                assessment.getMissingSkills(),
                roadmap.getRoadmap()
        );
    }
}