package com.productmanagement.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "category_master")
public class CategoryMasterEntity {
	
	@Id
	@Column(name = "cm_id")	
	private long categoryId;

	@Column(name = "cm_name")
	private String categoryName;

	
	


	public CategoryMasterEntity(long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public CategoryMasterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
	
	
}
