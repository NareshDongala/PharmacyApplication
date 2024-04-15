package com.jsp.PharmacyApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.PharmacyApplication.entity.MedicalStore;

public interface MedicalStoreRepo extends JpaRepository<MedicalStore,Integer>{

}
