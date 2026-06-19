package com.moksha.developer_growth_tracker.controller;

import com.moksha.developer_growth_tracker.dto.ProgressResponse;
import com.moksha.developer_growth_tracker.service.ProgressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(
            ProgressService progressService) {

        this.progressService =
                progressService;
    }

    @GetMapping("/{email}")
    public ProgressResponse progress(
            @PathVariable String email) {

        return progressService
                .getProgress(email);
    }
}