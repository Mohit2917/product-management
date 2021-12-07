package com.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.productmanagement.dto.ProductDto;
import com.productmanagement.entites.ProductEntity;
import com.productmanagement.service.ProductService;

@RequestMapping("/product")
@RestController
public class ProductRestController {

    @Qualifier("ProductServiceDbImpl")
	private ProductService productService;
    
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }
	
    @GetMapping
    public List<ProductEntity> getAllProduct() {
        return productService.getAllProduct();
    }
	
    
    @GetMapping({"/{productId}"})
    public ProductEntity getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }
	
    
	@PostMapping
	public ProductEntity addProduct(@RequestBody ProductDto productDto) {
		return productService.addProduct(productDto);
	}
	
	@PutMapping("/{productId}")
	public ProductEntity updateProduct(@PathVariable Long productId,@RequestBody ProductDto productDto) {
		productService.updateProduct(productId, productDto);
        return productService.getProductById(productId);
	}
	
	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable Long productId) {
		productService.deleteProduct(productId);	
	}
	

}