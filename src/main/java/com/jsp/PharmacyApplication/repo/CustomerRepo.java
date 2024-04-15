package com.jsp.PharmacyApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.PharmacyApplication.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer>{

}
