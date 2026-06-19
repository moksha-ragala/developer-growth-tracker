package com.moksha.developer_growth_tracker.repository;

import com.moksha.developer_growth_tracker.entity.ProgressHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressHistoryRepository
        extends JpaRepository<ProgressHistory, Long> {

    List<ProgressHistory>
    findByEmailOrderByCreatedAtDesc(
            String email
    );
}