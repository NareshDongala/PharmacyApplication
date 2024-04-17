package com.jsp.PharmacyApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.PharmacyApplication.entity.Admin;
import com.jsp.PharmacyApplication.repo.AdminRepo;
@Repository
public class AdminDao {
@Autowired
private AdminRepo adminRepo;

public Admin saveAdmin(Admin admin) {
	return adminRepo.save(admin);
}
public Admin updateAdmin(int adminId,Admin admin) {
	Optional<Admin> optional=adminRepo.findById(adminId);
	if(optional.isPresent()) {
		admin.setAdminId(adminId);
		return adminRepo.save(admin);
	}
	return null;
}

public Admin findAdmin(int adminId) {
	Optional<Admin> optional=adminRepo.findById(adminId);
	if(optional.isPresent()) {
		//id is present
		return optional.get();
		
	}
	return null;
	
}
public Admin deleteAdmin(int adminId) {
	Optional<Admin> optional=adminRepo.findById(adminId);
	if(optional.isPresent()) {
		adminRepo.deleteById(adminId);
		return optional.get();
		
	}
	return null;
}
public List<Admin> findall()
{
	 return adminRepo.findAll();
}

}
