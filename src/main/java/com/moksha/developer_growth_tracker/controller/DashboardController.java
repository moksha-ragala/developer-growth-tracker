package com.moksha.developer_growth_tracker.controller;

import com.moksha.developer_growth_tracker.dto.DashboardResponse;
import com.moksha.developer_growth_tracker.service.DashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(
            DashboardService dashboardService) {

        this.dashboardService = dashboardService;
    }

    @GetMapping("/{email}")
    public DashboardResponse dashboard(
            @PathVariable String email) {

        return dashboardService.getDashboard(
                email
        );
    }
}