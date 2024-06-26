package com.jsp.PharmacyApplication.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class CoustomerDto {
	 private int customerId;
	 private String customerName;
	 private String customerEmail;
	 
	 @OneToMany
	 private List<AdressDto> adressDtos;
	 
	 @OneToMany
	 private List<BookingDto> bookingDtos;
}
