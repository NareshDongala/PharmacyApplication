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

import com.jsp.PharmacyApplication.dto.AdminDto;
import com.jsp.PharmacyApplication.entity.Admin;
import com.jsp.PharmacyApplication.service.AdminService;
import com.jsp.PharmacyApplication.util.ResponseStructuer;

@RestController
@RequestMapping("/admin")
public class AdminController {
@Autowired
private AdminService adminService;
@PostMapping
public ResponseEntity<ResponseStructuer<AdminDto>> saveAdmin(@RequestBody Admin admin){
	return adminService.saveAdmin(admin);
}
@PutMapping
public ResponseEntity<ResponseStructuer<AdminDto>> updateAdmin(@RequestParam int adminId,@RequestBody Admin admin){
	return adminService.updateAdmin(adminId, admin);
}
@GetMapping
public ResponseEntity<ResponseStructuer<AdminDto>> findAdmin(@RequestParam int adminId){
	return adminService.findAdmin(adminId);
}
@DeleteMapping
public ResponseEntity<ResponseStructuer<AdminDto>> deleteAdmin(@RequestParam int adminId){
	return adminService.deleteAdmin(adminId);
			
}

}
