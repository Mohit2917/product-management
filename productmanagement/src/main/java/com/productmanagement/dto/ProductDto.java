package com.productmanagement.dto;

import com.productmanagement.entites.UserEntity;

public class ProductDto {
	private String name;
	private CategoryMasterDto category;
	private int price;
	private UserEntity user;

	public ProductDto(String name, CategoryMasterDto category, int price, UserEntity user) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryMasterDto getCategory() {
		return category;
	}

	public void setCategory(CategoryMasterDto category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
