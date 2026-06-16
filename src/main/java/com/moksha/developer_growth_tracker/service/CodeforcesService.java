package com.moksha.developer_growth_tracker.service;

import com.moksha.developer_growth_tracker.dto.CodeforcesApiResponse;
import com.moksha.developer_growth_tracker.dto.CodeforcesResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CodeforcesService {

    public CodeforcesResponse getProfile(
            String handle) {

        String url =
                "https://codeforces.com/api/user.info?handles="
                        + handle;

        RestTemplate restTemplate =
                new RestTemplate();

        CodeforcesApiResponse response =
                restTemplate.getForObject(
                        url,
                        CodeforcesApiResponse.class
                );

        return response.getResult().get(0);
    }

    public int calculateScore(
            String handle) {

        CodeforcesResponse profile =
                getProfile(handle);

        Integer rating =
                profile.getRating();

        if (rating == null) {
            return 0;
        }

        if (rating < 1200) {
            return 20;
        }

        if (rating < 1400) {
            return 40;
        }

        if (rating < 1600) {
            return 60;
        }

        if (rating < 1900) {
            return 80;
        }

        return 100;
    }
}