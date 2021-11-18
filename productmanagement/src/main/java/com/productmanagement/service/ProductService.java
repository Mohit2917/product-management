package com.productmanagement.service;

import java.util.List;

import com.productmanagement.dto.Product;
import com.productmanagement.dto.ProductDto;

public interface ProductService {

	public List<Product> getAllProduct();

	public Product getProductById(Integer productId);

	public Product addProduct(ProductDto productDto);

	public Product updateProduct(Integer productId, ProductDto productDto);

	public Product deleteProduct(Integer productId);

}
