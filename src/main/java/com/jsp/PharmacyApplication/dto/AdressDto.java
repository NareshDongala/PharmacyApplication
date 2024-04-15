package com.jsp.PharmacyApplication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdressDto {
	private int adressId;
	private String streetname;
	private String city;
	private String state;
	private long pincode;
}
