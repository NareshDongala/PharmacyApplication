package com.jsp.PharmacyApplication.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.PharmacyApplication.dao.AdressDao;
import com.jsp.PharmacyApplication.dto.AdressDto;
import com.jsp.PharmacyApplication.entity.Adress;
import com.jsp.PharmacyApplication.exception.AdressIdNotFoundException;
import com.jsp.PharmacyApplication.util.ResponseStructuer;
@Service
public class AdressService {

	@Autowired
	private AdressDao adressDao;
	
	@Autowired
	private AdressDto dto;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public ResponseEntity<ResponseStructuer<AdressDto>> saveAdress(Adress adress) {
		Adress dbadress=adressDao.saveAdress(adress);
		AdressDto dto=this.modelMapper.map(dbadress, AdressDto.class);
		ResponseStructuer<AdressDto> structuer=new ResponseStructuer<AdressDto>();
		structuer.setMesaage("adress saved sucessfully");
		structuer.setHttpStatusCode(HttpStatus.CREATED.value());
		structuer.setData(dto);
		return new ResponseEntity<ResponseStructuer<AdressDto>>(structuer,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructuer<AdressDto>> updateAdress(int adressId, Adress adress) {
		Adress dbadress=adressDao.updateAdress(adressId, adress);
		if(dbadress!=null) {
			AdressDto dto=this.modelMapper.map(dbadress, AdressDto.class);
			ResponseStructuer<AdressDto> structuer=new ResponseStructuer<AdressDto>();
			structuer.setMesaage("adress updated sucessfully");
			structuer.setHttpStatusCode(HttpStatus.OK.value());
			structuer.setData(dto);
			return new ResponseEntity<ResponseStructuer<AdressDto>>(structuer,HttpStatus.OK);
		}
		else {
			throw new AdressIdNotFoundException("sorry failed to update the data");
		}
	}

	public ResponseEntity<ResponseStructuer<AdressDto>> findAdress(int adressId) {
	Adress dbadress=adressDao.findAdress(adressId);
	if(dbadress!=null) {
		AdressDto dto=this.modelMapper.map(dbadress, AdressDto.class);
		ResponseStructuer<AdressDto> structuer=new ResponseStructuer<AdressDto>();
		structuer.setMesaage("adress fetched sucessfully");
		structuer.setHttpStatusCode(HttpStatus.FOUND.value());
		structuer.setData(dto);
		return new ResponseEntity<ResponseStructuer<AdressDto>>(structuer,HttpStatus.FOUND);
	}else {
		throw new AdressIdNotFoundException("sorry failed to fetch the data");
	}
	
	}

	public ResponseEntity<ResponseStructuer<AdressDto>> deleteAdress(int adressId) {
	Adress dbAdress=adressDao.deleteAdress(adressId);
	if(dbAdress!=null) {
		AdressDto dto=this.modelMapper.map(dbAdress, AdressDto.class);
		ResponseStructuer<AdressDto> structuer=new ResponseStructuer<AdressDto>();
		structuer.setMesaage("adress deleted sucessfully");
		structuer.setHttpStatusCode(HttpStatus.FOUND.value());
		structuer.setData(dto);
		return new ResponseEntity<ResponseStructuer<AdressDto>>(structuer,HttpStatus.FOUND);
	}else {
		throw new AdressIdNotFoundException("sorry failed to delete the data");
	}
	}

}
