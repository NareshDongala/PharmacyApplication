package com.jsp.PharmacyApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.PharmacyApplication.util.ResponseStructuer;
@RestControllerAdvice
public class OnlinePharmacyExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler
   public ResponseEntity<ResponseStructuer<String>> adminIdnotFoundException(AdminIdNotFoundException adminIdNotFoundException){
	   ResponseStructuer<String> structuer=new ResponseStructuer<String>();
	   structuer.setMesaage("ADMIN ID NOT FOUND");
	   structuer.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
	   structuer.setData(adminIdNotFoundException.getMessage());
	   return new ResponseEntity<ResponseStructuer<String>>(structuer,HttpStatus.NOT_FOUND);
   }
	@ExceptionHandler
	public ResponseEntity<ResponseStructuer<String>> adressIdnotFoundException( AdressIdNotFoundException  adressIdNotFoundException){
		   ResponseStructuer<String> structuer=new ResponseStructuer<String>();
		   structuer.setMesaage("ADRESS ID NOT FOUND");
		   structuer.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
		   structuer.setData(adressIdNotFoundException.getMessage());
		   return new ResponseEntity<ResponseStructuer<String>>(structuer,HttpStatus.NOT_FOUND);
	   }
	@ExceptionHandler
	public ResponseEntity<ResponseStructuer<String>> medicalStoreIdNotfoundException( MedicalStoreIdNotFoundException  medicalStoreIdNotFoundException){
		   ResponseStructuer<String> structuer=new ResponseStructuer<String>();
		   structuer.setMesaage("STORE ID NOT FOUND");
		   structuer.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
		   structuer.setData(medicalStoreIdNotFoundException.getMessage());
		   return new ResponseEntity<ResponseStructuer<String>>(structuer,HttpStatus.NOT_FOUND);
	   }
}
