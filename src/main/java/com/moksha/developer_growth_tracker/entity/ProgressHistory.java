package com.moksha.developer_growth_tracker.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ProgressHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private Integer developerScore;

    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeveloperScore() {
        return developerScore;
    }

    public void setDeveloperScore(Integer developerScore) {
        this.developerScore = developerScore;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}