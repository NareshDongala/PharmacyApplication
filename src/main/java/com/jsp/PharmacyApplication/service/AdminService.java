package com.jsp.PharmacyApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.PharmacyApplication.dao.AdminDao;
import com.jsp.PharmacyApplication.entity.Admin;
import com.jsp.PharmacyApplication.exception.AdminIdNotFoundException;
import com.jsp.PharmacyApplication.util.ResponseStructuer;
@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public ResponseEntity<ResponseStructuer<Admin>> saveAdmin(Admin admin){
		Admin dbadmin=adminDao.saveAdmin(admin);
		ResponseStructuer<Admin> structuer=new ResponseStructuer<Admin>();
		structuer.setMesaage("admin data saved sucessfully");
		structuer.setHttpStatusCode(HttpStatus.CREATED.value());
		structuer.setData(dbadmin);
		return new ResponseEntity<ResponseStructuer<Admin>>(structuer,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructuer<Admin>> updateAdmin(int adminId,Admin admin){
		Admin dbadmin=adminDao.updateAdmin(adminId, admin);
		if(dbadmin!=null) {
			ResponseStructuer<Admin> structuer=new ResponseStructuer<Admin>();
			structuer.setMesaage("data updated sucessfully");
			structuer.setHttpStatusCode(HttpStatus.OK.value());
			structuer.setData(dbadmin);
			return new ResponseEntity<ResponseStructuer<Admin>>(structuer,HttpStatus.OK);
		}else {
			//that id is not present and data not updated
			//raise the exception
			throw new AdminIdNotFoundException("sorry failed to update the data");
		}
	}
	public ResponseEntity<ResponseStructuer<Admin>> findAdmin(int adminId){
		Admin dbadmin=adminDao.findAdmin(adminId);
		if(dbadmin!=null) {
			ResponseStructuer<Admin> structuer=new ResponseStructuer<Admin>();
			structuer.setMesaage("data fetched sucessfully");
			structuer.setHttpStatusCode(HttpStatus.FOUND.value());
			structuer.setData(dbadmin);
			return new ResponseEntity<ResponseStructuer<Admin>>(structuer,HttpStatus.FOUND);
		}else {
			throw new AdminIdNotFoundException("sorry failed to fech the data");
			
		}
	}
	public ResponseEntity<ResponseStructuer<Admin>> deleteAdmin(int adminId){
		Admin dbadmin=adminDao.deleteAdmin(adminId);
		if(dbadmin!=null) {
			ResponseStructuer<Admin> structuer=new ResponseStructuer<Admin>();
			structuer.setMesaage("data deleted sucessfully");
			structuer.setHttpStatusCode(HttpStatus.FOUND.value());
			structuer.setData(dbadmin);
			return new ResponseEntity<ResponseStructuer<Admin>>(structuer,HttpStatus.FOUND);
		}else {
			throw new  AdminIdNotFoundException("sorry failed to delete the data");
		}
	}
}
