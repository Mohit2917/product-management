package product_management.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import product_management.dto.Product;

public class ProductServiceImpl implements ProductService {

	public Map<Integer, Product> productList = new HashMap<>();
	Scanner scan = new Scanner(System.in);

	@Override
	public void addProduct(int id, String name, String category, int price) {
		productList.put(id, new Product(name, category, price));
	}

	@Override
	public void showProduct() {

		// System.out.println(productList);
		for (Map.Entry entry : productList.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

	@Override
	public void updateProduct(int id, String name, String category, int price) {
		productList.replace(id, new Product(name, category, price));
	}

	@Override
	public boolean checkProductExist(int id) {
		return productList.containsKey(id);
	}

	@Override
	public void deleteProduct(int id) {
		productList.remove(id);
	}

	@Override
	public boolean checkProductNameExist(String name) {
		List<Product> pList = new ArrayList<>(productList.values());
		return pList.contains(name);
		//return productList.containsValue(name);
	}

}
