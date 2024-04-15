package com.jsp.PharmacyApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Adress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int adressId;
private String streetname;
private String city;
private String state;
private long pincode;

@ManyToOne
@JoinColumn
private Customer customer;

@OneToOne
@JoinColumn
private MedicalStore medicalStore;
}
