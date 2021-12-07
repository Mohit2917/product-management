package com.productmanagement.service;

import java.util.List;

import com.productmanagement.dto.UserDto;
import com.productmanagement.entites.UserEntity;


public interface UserService {


	public List<UserEntity> getAllProduct();

	public UserEntity findByEmail(String userEmail);

	public UserEntity addUser(UserDto userDto);

	public void updateUser(Long userId, UserDto userDto);

	public UserEntity getUserById(Long userId);

	public void deleteUser(Long userId);




}
