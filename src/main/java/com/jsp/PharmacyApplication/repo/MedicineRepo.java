package com.jsp.PharmacyApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.PharmacyApplication.entity.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine,Integer>{

}
