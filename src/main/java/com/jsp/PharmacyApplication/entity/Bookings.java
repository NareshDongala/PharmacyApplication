package com.jsp.PharmacyApplication.entity;

import java.time.LocalDate;
import java.util.List;

import com.jsp.PharmacyApplication.enums.BookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int bookinId;
private LocalDate orderDate;
private int quantity;
private String paymentMode;
private LocalDate expectDate;
private BookingStatus bookingStatus;


@ManyToMany
private List<Medicine> medicines;

@ManyToOne
@JoinColumn
private Customer customer;
}
