package com.jsp.PharmacyApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.PharmacyApplication.entity.Bookings;

public interface BookingRepo extends JpaRepository<Bookings, Integer>{

}
