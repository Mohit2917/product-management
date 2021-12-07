//package com.productmanagement.service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.productmanagement.dto.Product;
//import com.productmanagement.dto.ProductDto;
//
//public class ProductServiceImpl implements ProductService {
//	
//	private static Map<Integer,Product> productList = new HashMap<>();
//	private static int index=2;
//	
//	static {
//		Product product1 = new Product(1, "samsung a31","mobile",16000);
//		Product product2 = new Product(2, "latitude","laptop",109999);
//		productList.put(1,product1);
//		productList.put(2, product2);
//
//	}
//
//	@Override
//	public List<Product> getAllProduct() {
//		return new ArrayList<>(productList.values());
//	}
//
//	@Override
//	public Product getProductById(Integer productId) {
//		
//		Product product = productList.get(productId);
//		
//		return product;
//	}
//
//	@Override
//	public Product addProduct(ProductDto productDto) {
//		index++;
////		product.setId(index);
////		productList.put(index, product);
//		
//		Product p = new Product();
//		p.setId(index);
//		p.setName(productDto.getName());
//		p.setCategory(productDto.getCategory());
//		p.setPrice(productDto.getPrice());
//		return productList.put(index, p);
//		
//	}
//
//	@Override
//	public Product updateProduct(Integer productId, Product product) {
////		product.setId(productId);
////		productList.put(productId, product);
//		
//	
//		
//		Product up = new Product();
//		up.setId(productId);
//		up.setName(product.getName());
//		up.setCategory(product.getCategory());
//		up.setPrice(product.getPrice());
//		return productList.replace(productId, up);
//		
//	}
//
//	@Override
//	public Product deleteProduct(Integer productId) {
//		return productList.remove(productId);
//	}
//
//}