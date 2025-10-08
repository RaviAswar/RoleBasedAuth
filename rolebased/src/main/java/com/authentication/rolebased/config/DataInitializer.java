package com.authentication.rolebased.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.authentication.rolebased.entity.Role;
import com.authentication.rolebased.entity.User;
import com.authentication.rolebased.repository.RoleRepository;
import com.authentication.rolebased.repository.UserRepository;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(RoleRepository roleRepo, UserRepository userRepo, PasswordEncoder encoder) {
        return args -> {
            // Create Roles
            Role userRole = roleRepo.save(new Role(null, Role.RoleName.ROLE_USER));
            Role adminRole = roleRepo.save(new Role(null, Role.RoleName.ROLE_ADMIN));
            Role agencyRole = roleRepo.save(new Role(null, Role.RoleName.ROLE_AGENCY));

            // Create Users
            User user = new User(null, "user", encoder.encode("1234"), Set.of(userRole));
            User admin = new User(null, "admin", encoder.encode("1234"), Set.of(adminRole));
            User agency = new User(null, "agency", encoder.encode("1234"), Set.of(agencyRole));

            userRepo.save(user);
            userRepo.save(admin);
            userRepo.save(agency);
        };
    }
}

