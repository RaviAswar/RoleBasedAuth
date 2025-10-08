package com.authentication.rolebased.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello Public!";
    }

    @GetMapping("/user/dashboard")
    public String userDashboard() {
        return "Hello User!";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Hello Admin!";
    }

    @GetMapping("/agency/dashboard")
    public String agencyDashboard() {
        return "Hello Agency!";
    }
}

