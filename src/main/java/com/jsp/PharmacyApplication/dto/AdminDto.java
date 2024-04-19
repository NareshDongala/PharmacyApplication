package com.jsp.PharmacyApplication.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class AdminDto {
	 private int adminId;
	 private String adminname;
	 private String adminEmail;
}
