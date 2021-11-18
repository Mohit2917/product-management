package com.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productmanagement.dto.Product;
import com.productmanagement.dto.ProductDto;
import com.productmanagement.service.ProductService;
import com.productmanagement.service.ProductServiceImpl;

@RequestMapping("/product")
@RestController
public class ProductRestController {
	
	public ProductService productService = new ProductServiceImpl();
	
	@GetMapping
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
	}
	
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable Integer productId) {
		return productService.getProductById(productId);
	}
	
	@PostMapping
	public Product addProduct(@RequestBody ProductDto productDto) {
		return productService.addProduct(productDto);
	}
	
	@PutMapping("/{productId}")
	public Product updateProduct(@PathVariable Integer productId, ProductDto productDto) {
		
		return productService.updateProduct(productId, productDto);
	}
	
	@DeleteMapping("/{productId}")
	public Product deleteProduct(@PathVariable Integer productId) {
		return productService.deleteProduct(productId);
		
	}
	

}
