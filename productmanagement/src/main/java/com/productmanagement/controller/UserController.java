package com.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productmanagement.dto.UserDto;
import com.productmanagement.entites.UserEntity;
import com.productmanagement.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
	
	@Qualifier("UserServiceImpl")
	private UserService userService;
	
    public UserController(UserService userService) {
		super();
		this.userService = userService;
	}



	@GetMapping
	public List<UserEntity> getAllProduct() {
		return userService.getAllProduct();
	}

	@GetMapping("/{userEmail}")
	public UserEntity findByEmail(@PathVariable String userEmail) {
		return userService.findByEmail(userEmail);
	}

	@PostMapping
	public UserEntity addUser(@RequestBody UserDto userDto) {
		return userService.addUser(userDto);
	}

	@PutMapping("/{userId}")
	public UserEntity updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
		userService.updateUser(userId, userDto);
		return userService.getUserById(userId);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}
}
