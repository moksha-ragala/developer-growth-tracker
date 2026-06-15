package com.moksha.developer_growth_tracker.controller;

import com.moksha.developer_growth_tracker.dto.DeveloperAssessmentResponse;
import com.moksha.developer_growth_tracker.service.AssessmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/developer")
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(
            AssessmentService assessmentService) {

        this.assessmentService = assessmentService;
    }

    @GetMapping("/assessment/{email}")
    public DeveloperAssessmentResponse assess(
            @PathVariable String email) {

        return assessmentService.assess(email);
    }
}