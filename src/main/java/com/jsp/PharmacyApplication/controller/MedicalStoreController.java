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

import com.jsp.PharmacyApplication.dto.MedicalStoreDto;
import com.jsp.PharmacyApplication.entity.MedicalStore;
import com.jsp.PharmacyApplication.service.MedicalStoreService;
import com.jsp.PharmacyApplication.util.ResponseStructuer;

@RestController
@RequestMapping("/medicalstore")
public class MedicalStoreController {
@Autowired
private MedicalStoreService service;


@PostMapping
public ResponseEntity<ResponseStructuer<MedicalStoreDto>> saveMedicalStore(@RequestParam int adressId,@RequestParam int adminId,@RequestBody MedicalStore medicalStore ){
	return service.saveMediclStore(adminId, adressId, medicalStore);
}
	
@PutMapping
public ResponseEntity<ResponseStructuer<MedicalStoreDto>> updateMedicalStore(@RequestParam int storeId,
		@RequestBody MedicalStore store){
	return service.updateMedicalStore(storeId,store);
}

@GetMapping
public ResponseEntity<ResponseStructuer<MedicalStoreDto>> findMedicalStore(@RequestParam int storeId){
	return service.findMedicalStore(storeId);
}

@DeleteMapping
public ResponseEntity<ResponseStructuer<MedicalStoreDto>> deleteMedicalStore(@RequestParam int storeId){
	return service.deleteMedicalStore(storeId);
}
}
