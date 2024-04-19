package com.jsp.PharmacyApplication.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.PharmacyApplication.dao.AdminDao;
import com.jsp.PharmacyApplication.dto.AdminDto;
import com.jsp.PharmacyApplication.entity.Admin;
import com.jsp.PharmacyApplication.exception.AdminIdNotFoundException;
import com.jsp.PharmacyApplication.util.ResponseStructuer;
@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminDto dto;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<ResponseStructuer<AdminDto>> saveAdmin(Admin admin){
		Admin dbadmin=adminDao.saveAdmin(admin);
		AdminDto dto=this.modelMapper.map(dbadmin,AdminDto.class);
		ResponseStructuer<AdminDto> structuer=new ResponseStructuer<>();
		
		structuer.setMesaage("admin data saved sucessfully");
		structuer.setHttpStatusCode(HttpStatus.CREATED.value());
		structuer.setData(dto);
		return new ResponseEntity<ResponseStructuer<AdminDto>>(structuer,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructuer<AdminDto>> updateAdmin(int adminId,Admin admin){
		Admin dbadmin=adminDao.updateAdmin(adminId, admin);
		if(dbadmin!=null) {
			AdminDto dto=this.modelMapper.map(dbadmin,AdminDto.class);
			ResponseStructuer<AdminDto> structuer=new ResponseStructuer<>();
			structuer.setMesaage("data updated sucessfully");
			structuer.setHttpStatusCode(HttpStatus.OK.value());
			structuer.setData(dto);
			return new ResponseEntity<ResponseStructuer<AdminDto>>(structuer,HttpStatus.OK);
		}else {
			//that id is not present and data not updated
			//raise the exception
			throw new AdminIdNotFoundException("sorry failed to update the data");
		}
	}
	public ResponseEntity<ResponseStructuer<AdminDto>> findAdmin(int adminId){
		Admin dbadmin=adminDao.findAdmin(adminId);
		if(dbadmin!=null) {
			AdminDto dto=this.modelMapper.map(dbadmin, AdminDto.class);
//			that admin is there and data updated successfully
			ResponseStructuer<AdminDto> structuer=new ResponseStructuer<>();
			structuer.setMesaage("data fetched sucessfully");
			structuer.setHttpStatusCode(HttpStatus.FOUND.value());
			structuer.setData(dto);
			return new ResponseEntity<ResponseStructuer<AdminDto>>(structuer,HttpStatus.FOUND);
		}else {
			throw new AdminIdNotFoundException("sorry failed to fech the data");
			
		}
	}
	public ResponseEntity<ResponseStructuer<AdminDto>> deleteAdmin(int adminId){
		Admin dbadmin=adminDao.deleteAdmin(adminId);
		if(dbadmin!=null) {
			AdminDto dto=this.modelMapper.map(dbadmin, AdminDto.class);
//			that admin is there and data updated successfully
			ResponseStructuer<AdminDto> structuer=new ResponseStructuer<AdminDto>();
			structuer.setMesaage("data deleted sucessfully");
			structuer.setHttpStatusCode(HttpStatus.FOUND.value());
			structuer.setData(dto);
			return new ResponseEntity<ResponseStructuer<AdminDto>>(structuer,HttpStatus.FOUND);
		}else {
//			that id is not present and data not fetched
//			raise the exception
//			how to raise the exception
			throw new  AdminIdNotFoundException("sorry failed to delete the data");
		}
	}
}
