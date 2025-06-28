package com.ridesharing.authservice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ridesharing.authservice.entity.Otp;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Long> {

	Optional<Otp> findByPhoneNo(String phone);
}
