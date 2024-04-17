package com.jsp.PharmacyApplication.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.PharmacyApplication.entity.Adress;
import com.jsp.PharmacyApplication.repo.AdreesRepo;
@Repository
public class AdressDao {

	@Autowired
	private AdreesRepo adreesRepo;
	
	public Adress saveAdress(Adress adress) {
		return adreesRepo.save(adress);
	}
	public Adress updateAdress(int adressId,Adress adress) {
		Optional<Adress> optional=adreesRepo.findById(adressId);
		if(optional.isPresent()) {
			adress.setAdressId(adressId);
			return adreesRepo.save(adress);
		}
		return null;
	}
	public Adress findAdress(int adressId) {
		Optional<Adress> optional=adreesRepo.findById(adressId);
	    if(optional.isPresent())
	    {
	    	return optional.get();
	    }
	    return null;
	}
	public Adress deleteAdress(int adressId) {
		Optional<Adress> optional=adreesRepo.findById(adressId);
	    if(optional.isPresent()) {
	    	adreesRepo.deleteById(adressId);
	    	return optional.get();
	    }
	    return null;
	}
}
