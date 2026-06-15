package com.moksha.developer_growth_tracker.controller;

import com.moksha.developer_growth_tracker.dto.CodeforcesResponse;
import com.moksha.developer_growth_tracker.service.CodeforcesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/codeforces")
public class CodeforcesController {

    private final CodeforcesService codeforcesService;

    public CodeforcesController(
            CodeforcesService codeforcesService) {

        this.codeforcesService =
                codeforcesService;
    }

    @GetMapping("/{handle}")
    public CodeforcesResponse profile(
            @PathVariable String handle) {

        return codeforcesService
                .getProfile(handle);
    }
}