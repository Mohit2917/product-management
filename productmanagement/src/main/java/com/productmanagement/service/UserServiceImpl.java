package com.productmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.productmanagement.dto.UserDto;
import com.productmanagement.entites.UserEntity;
import com.productmanagement.passwordEncoder.CustomPasswordEncoder;
import com.productmanagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	private CustomPasswordEncoder passEncoder = new CustomPasswordEncoder();

	@Override
	public List<UserEntity> getAllProduct() {
		return userRepo.findAll();
	}

	@Override
	public UserEntity findByEmail(String userEmail) {
		UserEntity findByEmail = userRepo.findByEmail(userEmail);
		if (findByEmail != null) {
			return findByEmail;
		}
		throw new EmptyResultDataAccessException("user not found by this email", 1);
	}

	@Override
	public UserEntity addUser(UserDto userDto) {
		UserEntity ue = new UserEntity();
		ue.setFirstName(userDto.getFirstName());
		ue.setLastName(userDto.getLastName());
		ue.setEmail(userDto.getEmail());
		ue.setPassword(passEncoder.encode(userDto.getPassword()));
		return userRepo.save(ue);
	}

	@Override
	public void updateUser(Long userId, UserDto userDto) {
		UserEntity ue = new UserEntity();
		ue.setFirstName(userDto.getFirstName());
		ue.setLastName(userDto.getLastName());
		ue.setEmail(userDto.getEmail());
		ue.setPassword(userDto.getPassword());
		userRepo.save(ue);

	}

	@Override
	public UserEntity getUserById(Long userId) {
		return userRepo.getById(userId);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepo.deleteById(userId);
	}

}
