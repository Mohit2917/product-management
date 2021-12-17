package product_management.controller;

import java.util.Scanner;

import product_management.service.ProductService;
import product_management.service.ProductServiceImpl;

public class ProductController {
	static int id;
	static String name;
	static String category;
	static int price;
	ProductService ps = new ProductServiceImpl();
	Scanner scan = new Scanner(System.in);

	public void addProduct() {
		System.out.print("enter product id: ");
		id = scan.nextInt();
		System.out.print("enter product name: ");
		name = scan.next();
		System.out.print("enter product category: ");
		category = scan.next();
		System.out.print("enter product price: ");
		price = scan.nextInt();
		
		if (!ps.checkProductNameExist(name)) {
			ps.addProduct(id, name, category, price);
			System.out.println("product added successfully...!");
		} else {
			System.out.println("product already exist...!");
		}
	}

	public void showProduct() {
		ps.showProduct();

	}

	public void updateProduct() {
		System.out.print("enter id to update: ");
		id = scan.nextInt();

		if (ps.checkProductExist(id)) {
			System.out.print("enter new name: ");
			name = scan.next();
			System.out.print("enter new category: ");
			category = scan.next();
			System.out.print("enter new price: ");
			price = scan.nextInt();

			ps.updateProduct(id, name, category, price);
			System.out.println("record updated successfully...!");
		} else {
			System.out.println("Record not found...!");
		}

	}

	public void deleteProduct() {
		System.out.print("enter id to delete: ");
		id = scan.nextInt();
		if (ps.checkProductExist(id)) {
			ps.deleteProduct(id);
			System.out.println("record deleted successfully...!");
		} else {
			System.out.println("Record not found...!");
		}
	}

}
