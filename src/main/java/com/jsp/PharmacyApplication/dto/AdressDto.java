package com.jsp.PharmacyApplication.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class AdressDto {
	private int adressId;
	private String streetname;
	private String city;
	private String state;
	private long pincode;
}
