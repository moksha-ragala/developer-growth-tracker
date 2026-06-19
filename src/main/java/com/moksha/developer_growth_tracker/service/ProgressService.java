package com.moksha.developer_growth_tracker.service;

import com.moksha.developer_growth_tracker.dto.ProgressResponse;
import com.moksha.developer_growth_tracker.entity.ProgressHistory;
import com.moksha.developer_growth_tracker.repository.ProgressHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {

    private final ProgressHistoryRepository repository;

    public ProgressService(
            ProgressHistoryRepository repository) {

        this.repository = repository;
    }

    public ProgressResponse getProgress(
            String email) {

        List<ProgressHistory> history =
                repository
                        .findByEmailOrderByCreatedAtDesc(
                                email
                        );

        if (history.isEmpty()) {

            return new ProgressResponse(
                    email,
                    0,
                    0,
                    0,
                    "No Assessment Data"
            );
        }

        if (history.size() == 1) {

            return new ProgressResponse(
                    email,
                    history.get(0).getDeveloperScore(),
                    0,
                    0,
                    "Need More Data"
            );
        }

        int current =
                history.get(0)
                        .getDeveloperScore();

        int previous =
                history.get(1)
                        .getDeveloperScore();

        int growth =
                current - previous;

        String status;

        if (growth > 0) {
            status = "Improving";
        } else if (growth < 0) {
            status = "Declining";
        } else {
            status = "Stable";
        }

        return new ProgressResponse(
                email,
                current,
                previous,
                growth,
                status
        );
    }
}