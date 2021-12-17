package com.productmanagement.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productmanagement.controller.SecurityController;
import com.productmanagement.entites.UserEntity;
import com.productmanagement.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SecurityController securityController;
	


	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepo.findByEmail(username);
		if (user != null) {
			return new User(user.getEmail(), user.getPassword(), buildSimpleGrantedAuthorities());
		} else {
			throw new UsernameNotFoundException("User not found with userEmail: " + username);
		}
	}

	private static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		return authorities;
	}
	
	public UserEntity getUserDetails() {
		String currentUserName = securityController.currentUserName();
		UserEntity user = userRepo.findByEmail(currentUserName);
		return user;
	}
	

		

}
