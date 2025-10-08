package com.authentication.rolebased.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authentication.rolebased.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

