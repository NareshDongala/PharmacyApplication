package com.jsp.PharmacyApplication.exception;

import lombok.Getter;

@Getter
public class AdressIdNotFoundException extends RuntimeException {
  private String message;

public AdressIdNotFoundException(String message) {
	super();
	this.message = message;
}
  
}
