package com.ridesharing.authservice.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ridesharing.authservice.dto.AuthResponse;
import com.ridesharing.authservice.dto.LoginRequest;
import com.ridesharing.authservice.entity.Otp;
import com.ridesharing.authservice.repository.OtpRepository;

@Service
public class AuthService {

  @Autowired
  private OtpRepository otpRepo;
  
  private static Logger logger=LoggerFactory.getLogger(AuthService.class);
  
  public AuthResponse login(LoginRequest request) {
	    ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
	    String phone = request.phoneNo();
	    String otp = String.format("%04d", new Random().nextInt(10000));
	    Optional<Otp> existing = otpRepo.findByPhoneNo(phone);
	    Otp otpEntity;
	    if (existing.isPresent()) {
	        otpEntity = existing.get();
	        otpEntity.setOtp(otp);
	        otpEntity.setModifiedAt(now);
	    } else {
	        otpEntity = new Otp();
	        otpEntity.setPhoneNo(phone);
	        otpEntity.setOtp(otp);
	        otpEntity.setCreatedAt(now);
	        otpEntity.setModifiedAt(now);
	    }
	    otpRepo.save(otpEntity);
	    logger.info("OTP sent successfully {}", phone, otp);
	    return new AuthResponse("OTP sent successfully", phone, otp,otpEntity.getCreatedAt(),otpEntity.getModifiedAt()); // remove OTP in prod!
	}
  
    
}
