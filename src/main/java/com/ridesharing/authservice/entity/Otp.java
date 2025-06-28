package com.ridesharing.authservice.entity;

import java.time.ZonedDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "otp_verification", uniqueConstraints = {
	    @UniqueConstraint(columnNames = "phoneNo")
	})
@Getter
@Setter
@ToString
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNo;
    private String otp;
    private ZonedDateTime  createdAt;
    private ZonedDateTime  modifiedAt;
}
