package org.example.day81.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.example.day81.dto.AdminAuthDto;
import org.example.day81.dto.AdminLoginResponseDto;
import org.example.day81.dto.UserLoginDto;
import org.example.day81.dto.UserLoginResponseDto;
import org.example.day81.model.AdminEntity;
import org.example.day81.model.UserEntity;
import org.example.day81.model.UserType;
import org.example.day81.repository.AdminRepo;
import org.example.day81.repository.UserRepo;
import org.example.day81.security.CustomUserDetailsService;
import org.example.day81.security.JwtGenerator;

@RestController
@RequestMapping("/")
public class AuthController {
	
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtGenerator jwtGenerator;
	
	@PostMapping("api/v1/adminRegister")
	public ResponseEntity<String> adminRegister(@RequestBody AdminAuthDto adminAuthDto) {
		if(adminRepo.existsByUsername(adminAuthDto.getUsername())) {
			return new ResponseEntity<String>("Username is taken !! ",HttpStatus.BAD_REQUEST);
		}
		AdminEntity adminEntity = new AdminEntity();
		adminEntity.setUsername(adminAuthDto.getUsername());
		adminEntity.setPassword(passwordEncoder.encode(adminAuthDto.getPassword()));
		
		adminRepo.save(adminEntity);
		return new ResponseEntity<String>("User Register successfull !! ", HttpStatus.CREATED);
	}
	
	@PostMapping("api/v1/adminLogin")
	public ResponseEntity<AdminLoginResponseDto> login(@RequestBody AdminAuthDto adminAuthDto) {
		System.out.println("adminLogin");
		customUserDetailsService.setUserType(UserType.ADMIN);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(adminAuthDto.getUsername(), adminAuthDto.getPassword())); 
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtGenerator.generateToken(authentication,UserType.ADMIN.toString());
		AdminLoginResponseDto responseDto = new AdminLoginResponseDto();
		responseDto.setSuccess(true);
		responseDto.setMessage("login successful !!");
		responseDto.setToken(token);
		AdminEntity admin = adminRepo.findByUsername(adminAuthDto.getUsername()).orElseThrow();
		responseDto.setAdmin(admin.getUsername(), admin.getId());
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PostMapping("api/v1/userLogin")
	public ResponseEntity<UserLoginResponseDto> userLogin(@RequestBody UserLoginDto userLoginDto) {
		System.out.println("userLogin");
		customUserDetailsService.setUserType(UserType.USER);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtGenerator.generateToken(authentication, UserType.USER.toString());
		UserLoginResponseDto responseDto = new UserLoginResponseDto();
		responseDto.setSuccess(true);
		responseDto.setMessage("login successful !!");
		responseDto.setToken(token);
		UserEntity teacher = userRepo.findByEmail(userLoginDto.getEmail()).orElseThrow();
		responseDto.setTeacher(teacher.getName(), teacher.getEmail(), teacher.getId());
		return new ResponseEntity<UserLoginResponseDto>(responseDto, HttpStatus.OK);
	}

}
