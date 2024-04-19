package com.jsp.PharmacyApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.PharmacyApplication.dao.AdminDao;
import com.jsp.PharmacyApplication.dao.AdressDao;
import com.jsp.PharmacyApplication.dao.MedicalStoreDao;
import com.jsp.PharmacyApplication.dto.AdminDto;
import com.jsp.PharmacyApplication.dto.AdressDto;
import com.jsp.PharmacyApplication.dto.MedicalStoreDto;
import com.jsp.PharmacyApplication.entity.Admin;
import com.jsp.PharmacyApplication.entity.Adress;
import com.jsp.PharmacyApplication.entity.MedicalStore;
import com.jsp.PharmacyApplication.exception.AdminIdNotFoundException;
import com.jsp.PharmacyApplication.exception.AdressIdNotFoundException;
import com.jsp.PharmacyApplication.exception.MedicalStoreIdNotFoundException;
import com.jsp.PharmacyApplication.util.ResponseStructuer;
@Service
public class MedicalStoreService {

	@Autowired
	private MedicalStoreDao dao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	
	private AdressDao adressDao;
	
	@Autowired 
	private MedicalStoreDto dto;
	
	@Autowired
	private AdminDto adminDto;
	
	@Autowired
	private AdressDto adressDto;
	
	public ResponseEntity<ResponseStructuer<MedicalStoreDto>> saveMediclStore(int adminId,int adressId,MedicalStore medicalStore){
		Admin dbAdmin=adminDao.findAdmin(adminId);
		if(dbAdmin!=null) {
		//	admin is present and he is a valid admin
//			then im going to check address
			Adress dbAdress=adressDao.findAdress(adressId);
			if(dbAdress!=null) {
			//	adress is present then you can add store
//				next 2-4 lines is added in 19-04-2024
				medicalStore.setAdmin(dbAdmin);
				medicalStore.setAdress(dbAdress);
				MedicalStore dbMedicalStore=dao.saveMedicalStore(medicalStore);
				dbAdress.setMedicalStore(dbMedicalStore);
				dto.setManagerName(dbMedicalStore.getManagerName());
				dto.setName(dbMedicalStore.getName());
				dto.setPhone(dbMedicalStore.getPhone());
				dto.setStoreId(dbMedicalStore.getStoreId());
			 Adress  adress= dbMedicalStore.getAdress();
				adressDto.setAdressId(adress.getAdressId());
				adressDto.setCity(adress.getCity());
				adressDto.setPincode(adress.getPincode());
				adressDto.setState(adress.getState());
				adressDto.setStreetname(adress.getStreetname());
				
				dto.setAdressDto(adressDto);
				
				
				Admin admin=dbMedicalStore.getAdmin();
				  adminDto.setAdminEmail(admin.getAdminEmail());
				  adminDto.setAdminId(admin.getAdminId());
				  adminDto.setAdminname(admin.getAdminname());
				  
				  dto.setAdminDto(adminDto);
				  
				  ResponseStructuer<MedicalStoreDto> structuer=new ResponseStructuer<MedicalStoreDto>();
				  structuer.setMesaage("medical store saved sucessfully");
				  structuer.setHttpStatusCode(HttpStatus.CREATED.value());
				  structuer.setData(dto);
				  return new ResponseEntity<ResponseStructuer<MedicalStoreDto>>(structuer,HttpStatus.CREATED);
						  
				
			}else {
				throw new AdressIdNotFoundException("soory failed to open the medical store");
			}
		}else {
			throw new AdminIdNotFoundException("sorry failed to open the medical store");
		}
		
		
	}
	public ResponseEntity<ResponseStructuer<MedicalStoreDto>> updateMedicalStore(int storeId,MedicalStore store){
		MedicalStore dbMedicalStore=dao.updateMedicalStore(storeId, store);
		if(dbMedicalStore!=null){
			
			dto.setManagerName(dbMedicalStore.getManagerName());
			dto.setName(dbMedicalStore.getName());
			dto.setPhone(dbMedicalStore.getPhone());
			dto.setStoreId(dbMedicalStore.getStoreId());
		 Adress  adress= dbMedicalStore.getAdress();
			adressDto.setAdressId(adress.getAdressId());
			adressDto.setCity(adress.getCity());
			adressDto.setPincode(adress.getPincode());
			adressDto.setState(adress.getState());
			adressDto.setStreetname(adress.getStreetname());
			
			dto.setAdressDto(adressDto);
			
			
			Admin admin=dbMedicalStore.getAdmin();
			  adminDto.setAdminEmail(admin.getAdminEmail());
			  adminDto.setAdminId(admin.getAdminId());
			  adminDto.setAdminname(admin.getAdminname());
			  
			  dto.setAdminDto(adminDto);
			  
			  ResponseStructuer<MedicalStoreDto> structuer=new ResponseStructuer<MedicalStoreDto>();
			  structuer.setMesaage("medical store saved sucessfully");
			  structuer.setHttpStatusCode(HttpStatus.OK.value());
			  structuer.setData(dto);
			  return new ResponseEntity<ResponseStructuer<MedicalStoreDto>>(structuer,HttpStatus.OK);
		}else {
			throw new MedicalStoreIdNotFoundException("sorry failed to update the data");
		}
	}
	public ResponseEntity<ResponseStructuer<MedicalStoreDto>> findMedicalStore(int storeId){
		MedicalStore dbMedicalStore=dao.findMedicalStore(storeId);
		if(dbMedicalStore!=null) {

			
			dto.setManagerName(dbMedicalStore.getManagerName());
			dto.setName(dbMedicalStore.getName());
			dto.setPhone(dbMedicalStore.getPhone());
			dto.setStoreId(dbMedicalStore.getStoreId());
			
			Adress adress=dbMedicalStore.getAdress();
			adressDto.setAdressId(adress.getAdressId());
			adressDto.setCity(adress.getCity());
			adressDto.setPincode(adress.getPincode());
			adressDto.setState(adress.getState());
			adressDto.setStreetname(adress.getStreetname());
			
			dto.setAdressDto(adressDto);
			
			Admin admin=dbMedicalStore.getAdmin();
			adminDto.setAdminEmail(admin.getAdminEmail());
			adminDto.setAdminId(admin.getAdminId());
			adminDto.setAdminname(admin.getAdminname());
			
			dto.setAdminDto(adminDto);
			
			
			ResponseStructuer<MedicalStoreDto> structure=new ResponseStructuer<>();
			structure.setMesaage("Medicalstore Fetched Sucessfully");
			structure.setHttpStatusCode(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructuer<MedicalStoreDto>>(structure,HttpStatus.FOUND);
			
			
			
		}else {
			throw new MedicalStoreIdNotFoundException("Sorry failed to fetch the MedicalStore");
		}
	}
	public ResponseEntity<ResponseStructuer<MedicalStoreDto>> deleteMedicalStore(int storeId){
		MedicalStore dbMedicalStore=dao.deleteMedicalStore(storeId);
if(dbMedicalStore!=null) {

			
			dto.setManagerName(dbMedicalStore.getManagerName());
			dto.setName(dbMedicalStore.getName());
			dto.setPhone(dbMedicalStore.getPhone());
			dto.setStoreId(dbMedicalStore.getStoreId());
			
			Adress adress=dbMedicalStore.getAdress();
			adressDto.setAdressId(adress.getAdressId());
			adressDto.setCity(adress.getCity());
			adressDto.setPincode(adress.getPincode());
			adressDto.setState(adress.getState());
			adressDto.setStreetname(adress.getStreetname());
			
			dto.setAdressDto(adressDto);
			
			Admin admin=dbMedicalStore.getAdmin();
			adminDto.setAdminEmail(admin.getAdminEmail());
			adminDto.setAdminId(admin.getAdminId());
			adminDto.setAdminname(admin.getAdminname());
			
			dto.setAdminDto(adminDto);
			
			
			ResponseStructuer<MedicalStoreDto> structure=new ResponseStructuer<>();
			structure.setMesaage("Medicalstore deleted Sucessfully");
			structure.setHttpStatusCode(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructuer<MedicalStoreDto>>(structure,HttpStatus.FOUND);
			
			
			
		}else {
			throw new MedicalStoreIdNotFoundException("Sorry failed to delete the MedicalStore");
		}
	}
	
}
