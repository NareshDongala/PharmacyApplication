package com.jsp.PharmacyApplication.dto;

import java.time.LocalDate;

import com.jsp.PharmacyApplication.enums.BookingStatus;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BookingDto {
	private int bookinId;
	private LocalDate orderDate;
	private int quantity;
	private String paymentMode;
	private LocalDate expectDate;
	private BookingStatus bookingStatus;

}
