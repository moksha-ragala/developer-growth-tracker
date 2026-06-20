package com.moksha.developer_growth_tracker.service;

import com.moksha.developer_growth_tracker.dto.LeetcodeStatsResponse;
import org.springframework.stereotype.Service;

@Service
public class LeetcodeService {

    public LeetcodeStatsResponse getStats(
            String username) {

        LeetcodeStatsResponse response =
                new LeetcodeStatsResponse();

        /*
         * Temporary data from your profile screenshot
         */

        response.setTotalSolved(257);

        response.setEasySolved(195);

        response.setMediumSolved(61);

        response.setHardSolved(1);

        response.setActiveDays(134);

        response.setMaxStreak(40);

        response.setSubmissionsLastYear(399);

        response.setBadges(2);

        return response;
    }

    public int calculateScore(
            LeetcodeStatsResponse stats) {

        int score = 0;

        score += stats.getEasySolved();

        score += stats.getMediumSolved() * 2;

        score += stats.getHardSolved() * 5;

        return Math.min(score / 5, 100);
    }
}