package com.jbk.product;

import java.util.Scanner;

import com.jbk.product.dao.ProductDao;
import com.jbk.product.entity.Product;
import com.jbk.product.service.ProductService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int choice;
		char ch;
		Scanner scanner = new Scanner(System.in);
		ProductService productService = new ProductService();
		do {

			System.out.println("Press 1 for save product");
			System.out.println("Press 2 to get single product");
			System.out.println("Press 3 to delete product");
			System.out.println("Press 4 to update product");
			
			choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				Product product= productService.productInfo();
				boolean isAdded=productService.addProduct(product);
			
				if (isAdded) {
					System.out.println("Product Saved !!");
				} else {
					System.out.println("Product not saved !!  ");
				}
				break;
			}
			case 2: {
				System.out.println("Enter Product Id");
				int id = scanner.nextInt();
				Product product = productService.getProductById(id);
				if (product != null) {
					System.out.println(product);
				} else {
					System.out.println(" Product Not Found For This Id " +product.getProductId());
				}
				break;
			}

			case 3: {
				System.out.println("Enter Id");
				int id = scanner.nextInt();
				boolean isDeleted = productService.deleteProductById(id);
				if (isDeleted) {
					System.out.println("Product Deleted !!");
				} else {
					System.out.println(" Product Not Found For This Id " + id);
				}
				break;
			}

			case 4: {

				Product product= productService.productInfo();
				
				boolean isUpdated=productService.updateProductInfo(product);
				if (isUpdated) {
					System.out.println("Product Updated !!");
				} else {
					System.out.println(" Product Not Found For This Id " + product.getProductId());
				}

				break;
			}

			

			default:
				break;
			}

			System.out.println("Do you want to continue y/n ");
			ch = scanner.next().charAt(0);
		} while (ch == 'y' || ch == 'Y');

		System.out.println("Termionated !! ");

	}


	}


