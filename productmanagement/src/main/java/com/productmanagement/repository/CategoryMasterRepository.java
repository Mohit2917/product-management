package com.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productmanagement.entites.CategoryMasterEntity;

public interface CategoryMasterRepository extends JpaRepository<CategoryMasterEntity, Long> {

}
