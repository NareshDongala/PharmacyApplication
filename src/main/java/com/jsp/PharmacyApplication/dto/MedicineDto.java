package com.jsp.PharmacyApplication.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter 
public class MedicineDto {
	private int medicineId;
	private String medicineName;
	private double cost;
	private LocalDate expirydate;
	private int stockQuantity;
	private String manufacuter;
	private String description;
}
