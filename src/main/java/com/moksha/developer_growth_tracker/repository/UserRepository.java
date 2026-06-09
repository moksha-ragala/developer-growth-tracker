package com.moksha.developer_growth_tracker.repository;

import com.moksha.developer_growth_tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

}