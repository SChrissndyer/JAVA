package org.example.day81.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.example.day81.dto.SuccessandMessageDto;
import org.example.day81.dto.UserRegisterDto;
import org.example.day81.model.UserEntity;
import org.example.day81.repository.AdminRepo;
import org.example.day81.repository.UserRepo;
import org.example.day81.security.JwtGenerator;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	
	@Autowired
	private JwtGenerator jwtGenerator;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private AdminRepo adminRepo;

	@PostMapping("/register")
	public ResponseEntity<SuccessandMessageDto> registerUser(@RequestBody UserRegisterDto userRegisterDto, @RequestHeader(name="Authorization") String token) {
		SuccessandMessageDto response = new SuccessandMessageDto();
		if(userRepo.existsByEmail(userRegisterDto.getEmail())) {
			response.setMessage("Email is already registered !!");
			response.setSuccess(false);
			return new ResponseEntity<SuccessandMessageDto>(response, HttpStatus.BAD_REQUEST);
		}
		UserEntity userEntity = new UserEntity();
		userEntity.setName(userRegisterDto.getUsername());
		userEntity.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
		userEntity.setEmail(userRegisterDto.getEmail());
		userEntity.setStatus(true);
		try {
			userEntity.setCreatedBy(adminRepo.findByUsername(jwtGenerator.getUsernameFromJWT(token.substring(7))).orElseThrow());
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			response.setMessage("Unauthorized request");
			response.setSuccess(false);
			return new ResponseEntity<SuccessandMessageDto>(response, HttpStatus.UNAUTHORIZED);
		}
		userRepo.save(userEntity);
		response.setMessage("Profile Created Successfully !!");
		response.setSuccess(true);
		return new ResponseEntity<SuccessandMessageDto>(response, HttpStatus.OK);
	}
}
