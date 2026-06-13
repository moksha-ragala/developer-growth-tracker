package com.moksha.developer_growth_tracker.service;

import com.moksha.developer_growth_tracker.dto.GithubAnalyticsResponse;
import com.moksha.developer_growth_tracker.dto.GithubCommitResponse;
import com.moksha.developer_growth_tracker.dto.GithubProfileResponse;
import com.moksha.developer_growth_tracker.dto.GithubRepoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class GithubService {

    public GithubProfileResponse getGithubProfile(
            String username) {

        String url =
                "https://api.github.com/users/" + username;

        RestTemplate restTemplate =
                new RestTemplate();

        return restTemplate.getForObject(
                url,
                GithubProfileResponse.class
        );
    }

    public List<GithubRepoResponse> getRepositories(
            String username) {

        String url =
                "https://api.github.com/users/"
                        + username
                        + "/repos";

        RestTemplate restTemplate =
                new RestTemplate();

        GithubRepoResponse[] repos =
                restTemplate.getForObject(
                        url,
                        GithubRepoResponse[].class
                );

        return Arrays.asList(repos);
    }

    public GithubAnalyticsResponse getAnalytics(
            String username) {

        GithubProfileResponse profile =
                getGithubProfile(username);

        List<GithubRepoResponse> repos =
                getRepositories(username);

        int totalCommits =
                getTotalCommits(username);

        int score = 0;

        score += Math.min(
                profile.getPublic_repos() * 2,
                30
        );

        score += Math.min(
                totalCommits / 5,
                50
        );

        if (profile.getBio() != null &&
                !profile.getBio().isBlank()) {

            score += 20;
        }

        return new GithubAnalyticsResponse(
                profile.getLogin(),
                profile.getFollowers(),
                profile.getPublic_repos(),
                totalCommits,
                score
        );
    }

    public int getTotalCommits(
            String username) {

        List<GithubRepoResponse> repos =
                getRepositories(username);

        RestTemplate restTemplate =
                new RestTemplate();

        int totalCommits = 0;

        for (GithubRepoResponse repo : repos) {

            String url =
                    "https://api.github.com/repos/"
                            + username
                            + "/"
                            + repo.getName()
                            + "/commits";

            try {

                GithubCommitResponse[] commits =
                        restTemplate.getForObject(
                                url,
                                GithubCommitResponse[].class
                        );

                if (commits != null) {
                    totalCommits += commits.length;
                }

            } catch (Exception e) {

                System.out.println(
                        "Skipping repo: "
                                + repo.getName()
                );
            }
        }

        return totalCommits;
    }
}