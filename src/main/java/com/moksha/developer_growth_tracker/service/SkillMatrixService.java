package com.moksha.developer_growth_tracker.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillMatrixService {

    public List<String> getRequiredSkills(
            String role) {

        if ("Java Full Stack Developer"
                .equalsIgnoreCase(role)) {

            return List.of(
                    "Java",
                    "Spring Boot",
                    "MySQL",
                    "React",
                    "Git",
                    "Docker",
                    "AWS",
                    "Redis",
                    "Kafka"
            );
        }

        return List.of();
    }
}