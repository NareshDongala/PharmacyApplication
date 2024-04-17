package com.jsp.PharmacyApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.PharmacyApplication.dao.AdressDao;
import com.jsp.PharmacyApplication.entity.Adress;
import com.jsp.PharmacyApplication.exception.AdressIdNotFoundException;
import com.jsp.PharmacyApplication.util.ResponseStructuer;
@Service
public class AdressService {

	@Autowired
	private AdressDao adressDao;
	public ResponseEntity<ResponseStructuer<Adress>> saveAdress(Adress adress) {
		Adress dbadress=adressDao.saveAdress(adress);
		ResponseStructuer<Adress> structuer=new ResponseStructuer<Adress>();
		structuer.setMesaage("adress saved sucessfully");
		structuer.setHttpStatusCode(HttpStatus.CREATED.value());
		structuer.setData(dbadress);
		return new ResponseEntity<ResponseStructuer<Adress>>(structuer,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructuer<Adress>> updateAdress(int adressId, Adress adress) {
		Adress dbadress=adressDao.updateAdress(adressId, adress);
		if(dbadress!=null) {
			ResponseStructuer<Adress> structuer=new ResponseStructuer<Adress>();
			structuer.setMesaage("adress updated sucessfully");
			structuer.setHttpStatusCode(HttpStatus.OK.value());
			structuer.setData(dbadress);
			return new ResponseEntity<ResponseStructuer<Adress>>(structuer,HttpStatus.OK);
		}
		else {
			throw new AdressIdNotFoundException("sorry failed to update the data");
		}
	}

	public ResponseEntity<ResponseStructuer<Adress>> findAdress(int adressId) {
	Adress dbadress=adressDao.findAdress(adressId);
	if(dbadress!=null) {
		ResponseStructuer<Adress> structuer=new ResponseStructuer<Adress>();
		structuer.setMesaage("adress fetched sucessfully");
		structuer.setHttpStatusCode(HttpStatus.FOUND.value());
		structuer.setData(dbadress);
		return new ResponseEntity<ResponseStructuer<Adress>>(structuer,HttpStatus.FOUND);
	}else {
		throw new AdressIdNotFoundException("sorry failed to fetch the data");
	}
	
	}

	public ResponseEntity<ResponseStructuer<Adress>> deleteAdress(int adressId) {
	Adress dbAdress=adressDao.deleteAdress(adressId);
	if(dbAdress!=null) {
		ResponseStructuer<Adress> structuer=new ResponseStructuer<Adress>();
		structuer.setMesaage("adress deleted sucessfully");
		structuer.setHttpStatusCode(HttpStatus.FOUND.value());
		structuer.setData(dbAdress);
		return new ResponseEntity<ResponseStructuer<Adress>>(structuer,HttpStatus.FOUND);
	}else {
		throw new AdressIdNotFoundException("sorry failed to delete the data");
	}
	}

}
