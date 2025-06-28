package com.ridesharing.authservice.dto;

public record RegisterRequest(String name, String email, String password, String role) {}
