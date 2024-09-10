package org.example.day81.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.example.day81.model.AdminEntity;
import org.example.day81.model.UserEntity;
import org.example.day81.model.UserType;
import org.example.day81.repository.AdminRepo;
import org.example.day81.repository.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private UserRepo userRepo;
	
	private UserType userType;
	
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(userType);
		if(userType==UserType.ADMIN) {
			
			AdminEntity adminEntity = adminRepo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Admin Username "+ username+ "not found"));
			
			SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(UserType.ADMIN.toString());
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(adminAuthority);
			return new User(adminEntity.getUsername(), adminEntity.getPassword(), authorities);
		} else if(userType == UserType.USER) {
			UserEntity userEntity = userRepo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("Teacher Email "+ username+ "not found"));
			
			SimpleGrantedAuthority teacherAuthority = new SimpleGrantedAuthority(UserType.USER.toString());
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(teacherAuthority);
			return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
		}
		return null;
	}
	
}
