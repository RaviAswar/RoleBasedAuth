package com.authentication.rolebased.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authentication.rolebased.entity.Role;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Role.RoleName name);
}


