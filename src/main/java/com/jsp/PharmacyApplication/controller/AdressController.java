package com.jsp.PharmacyApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.PharmacyApplication.entity.Adress;
import com.jsp.PharmacyApplication.service.AdressService;
import com.jsp.PharmacyApplication.util.ResponseStructuer;
@RestController
@RequestMapping("/adress")
public class AdressController {

	@Autowired
	private AdressService adressService;
	@PostMapping
	public ResponseEntity<ResponseStructuer<Adress>> saveAdress(@RequestBody Adress adress){
		return adressService.saveAdress(adress);
	}
	@PutMapping
	public ResponseEntity<ResponseStructuer<Adress>> updateAdress(@RequestParam int adressId,@RequestBody Adress adress){
		return adressService.updateAdress(adressId,adress);
	}
	@GetMapping
	public ResponseEntity<ResponseStructuer<Adress>> findAdress(@RequestParam int adressId){
		return adressService.findAdress(adressId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructuer<Adress>> deleteAdress(@RequestParam int adressId){
		return adressService.deleteAdress(adressId);
	}
}
