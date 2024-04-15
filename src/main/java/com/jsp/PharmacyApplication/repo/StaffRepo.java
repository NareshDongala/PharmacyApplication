package com.jsp.PharmacyApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.PharmacyApplication.entity.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer>{

}
