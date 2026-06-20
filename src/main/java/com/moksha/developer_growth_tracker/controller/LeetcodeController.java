package com.moksha.developer_growth_tracker.controller;

import com.moksha.developer_growth_tracker.dto.LeetcodeStatsResponse;
import com.moksha.developer_growth_tracker.service.LeetcodeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leetcode")
public class LeetcodeController {

    private final LeetcodeService leetcodeService;

    public LeetcodeController(
            LeetcodeService leetcodeService) {

        this.leetcodeService = leetcodeService;
    }

    @GetMapping("/{username}")
    public LeetcodeStatsResponse profile(
            @PathVariable String username) {

        return leetcodeService.getStats(username);
    }
}