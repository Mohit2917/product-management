package com.productmanagement.service;

import java.util.List;
import com.productmanagement.dto.ProductDto;
import com.productmanagement.entites.ProductEntity;

public interface ProductService {

	public List<ProductEntity> getAllProduct();

	public ProductEntity getProductById(Long productId);

	public ProductEntity addProduct(ProductDto productDto);

	public void updateProduct(Long productId, ProductDto productDto);

	public void deleteProduct(Long productId);

}
