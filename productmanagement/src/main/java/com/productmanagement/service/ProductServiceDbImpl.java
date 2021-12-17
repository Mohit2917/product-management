package com.productmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.productmanagement.dto.ProductDto;
import com.productmanagement.entites.ProductEntity;
import com.productmanagement.repository.ProductRepository;

@Service
public class ProductServiceDbImpl implements ProductService {
	
	private ModelMapper mapper;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserDetailsServiceImpl UserDetailsService;
	

	 public ProductServiceDbImpl(ProductRepository productRepository, ModelMapper mapper) {
	        this.productRepository = productRepository;
	        this.mapper=mapper;
	    }

	@Override
	public List<ProductEntity> getAllProduct() {
		List<ProductEntity> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	@Override
	public ProductEntity getProductById(Long id) {
		Optional<ProductEntity> findById = productRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		throw new EmptyResultDataAccessException("product not found by this is", 1);
	}

	@Override
	public ProductEntity addProduct(ProductDto productDto) {
		ProductEntity dtoToEntity = dtoToEntity(productDto);
		ProductEntity pe = new ProductEntity();
		pe.setName(productDto.getName());
		pe.setCategory(dtoToEntity.getCategory());
		pe.setPrice(productDto.getPrice());
		pe.setUser(UserDetailsService.getUserDetails());
		return productRepository.save(pe);
	}

	@Override
	public void updateProduct(Long productId, ProductDto productDto) {
		ProductEntity dtoToEntity = dtoToEntity(productDto);
		ProductEntity productEntity = getProductById(productId);
		System.out.println(productEntity.toString());
		productEntity.setName(productDto.getName());
		productEntity.setCategory(dtoToEntity.getCategory());
		productEntity.setPrice(productDto.getPrice());
		productEntity.setUser(UserDetailsService.getUserDetails());
		productRepository.save(productEntity);
	}

	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}
	
	//convert entity to dto
	private ProductDto entityToDto(ProductEntity productEntity) {
		ProductDto productDto = mapper.map(productEntity, ProductDto.class);
		return productDto;
	}
	
	//convert dto to entity
	private ProductEntity dtoToEntity(ProductDto productDto) {
		ProductEntity productEntity = mapper.map(productDto, ProductEntity.class);
		return productEntity;
	}
	
   

}
