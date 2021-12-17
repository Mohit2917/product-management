package product_management.client;

import java.util.InputMismatchException;
import java.util.Scanner;


import product_management.controller.ProductController;

public class ProductCollectionMain {

	public static void main(String[] args) {
		
		ProductCollectionMain.choice();

	}
	static int ch;
	public static void choice() {
		ProductController pc = new ProductController();
		
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("1: Insert Product");
			System.out.println("2: Show Product");
			System.out.println("3: Update Product");
			System.out.println("4: Delete Product");
			System.out.println("0: Exit");
			
			
			
			
			boolean valid = false;
			while(!valid) {
			    try {
			    	System.out.print("enter ur choice: ");
			        ch = scan.nextInt();
			        if(ch >= 0) { 
			            valid = true;
			        }
			    }
			    catch (InputMismatchException e) {
			        System.out.println("input is numbers only");
			        scan.next(); // if remove this statement then loop will go to  infinite loop
			    }
			}
			
			
			switch(ch) {
			case 1:
				pc.addProduct();
			break;
			case 2:
				pc.showProduct();
			break;
			case 3:
				pc.updateProduct();
			break;
			case 4:
				pc.deleteProduct();
			break;
			default:
				System.out.println("enter valid input...!");
			}
			
			
		}while(ch!=0);
		scan.close();
	}


}
