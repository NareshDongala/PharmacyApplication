package com.jsp.PharmacyApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.PharmacyApplication.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer>{

}
