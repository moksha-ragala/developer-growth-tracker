package com.moksha.developer_growth_tracker.controller;

import com.moksha.developer_growth_tracker.dto.InsightsResponse;
import com.moksha.developer_growth_tracker.service.InsightsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/insights")
public class InsightsController {

    private final InsightsService insightsService;

    public InsightsController(
            InsightsService insightsService) {

        this.insightsService = insightsService;
    }

    @GetMapping("/{email}")
    public InsightsResponse insights(
            @PathVariable String email) {

        return insightsService
                .getInsights(email);
    }
}