package com.moksha.developer_growth_tracker.controller;

import com.moksha.developer_growth_tracker.dto.RoadmapResponse;
import com.moksha.developer_growth_tracker.service.RoadmapService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roadmap")
public class RoadmapController {

    private final RoadmapService roadmapService;

    public RoadmapController(
            RoadmapService roadmapService) {

        this.roadmapService =
                roadmapService;
    }

    @GetMapping("/{email}")
    public RoadmapResponse roadmap(
            @PathVariable String email) {

        return roadmapService
                .generateRoadmap(email);
    }
}