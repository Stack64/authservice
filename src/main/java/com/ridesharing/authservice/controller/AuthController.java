package com.ridesharing.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ridesharing.authservice.dto.AuthResponse;
import com.ridesharing.authservice.dto.LoginRequest;
import com.ridesharing.authservice.dto.RegisterRequest;
import com.ridesharing.authservice.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

//  @PostMapping("/register")
//  public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
//    return ResponseEntity.ok(authService.register(request));
//  }

  @GetMapping("/login")
  public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
    return ResponseEntity.ok(authService.login(request));
  }
  
//  @PostMapping("/verifyOtp")
//  public ResponseEntity<AuthResponse> login(@RequestBody  rkequest) {
//    return ResponseEntity.ok(authService.login(request));
//  }
  
}
