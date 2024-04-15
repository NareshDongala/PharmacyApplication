package com.jsp.PharmacyApplication.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int medicineId;
private String medicineName;
private double cost;
private LocalDate expirydate;
private int stockQuantity;
private String manufacuter;
private String description;

@ManyToOne
private MedicalStore medicalStore;
}
