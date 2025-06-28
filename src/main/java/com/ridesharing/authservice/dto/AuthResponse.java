package com.ridesharing.authservice.dto;

import java.time.ZonedDateTime;

public record AuthResponse(String message, String phoneNo, String otp,ZonedDateTime created_at,ZonedDateTime modifed_at) {}
