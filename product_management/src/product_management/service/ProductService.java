package product_management.service;

import product_management.dto.Product;

public interface ProductService {
	
	

	public void addProduct(int id, String name, String category, int price);

	public void showProduct();

	public void updateProduct(int id, String name, String category, int price);

	public boolean checkProductExist(int id);

	public void deleteProduct(int id);

	public boolean checkProductNameExist(String name);

}
