package com.jsp.PharmacyApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MedicalStore {
private int storeId;
private String name;
private String managerName;
private long phone;


@ManyToOne
private Admin  admin;

@OneToOne(mappedBy = "medicalStore")
private Adress adress;
}
