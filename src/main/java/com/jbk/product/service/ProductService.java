package com.jbk.product.service;

import java.util.Scanner;

import com.jbk.product.dao.ProductDao;
import com.jbk.product.entity.Product;

public class ProductService {
	
	ProductDao dao = new ProductDao();

public Product productInfo() {
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Id");
		int id=scanner.nextInt();
		
		System.out.println("Enter Product Name");
		String name=scanner.next();
		
		System.out.println("Enter Product Price");
		double price=scanner.nextDouble();
		
		System.out.println("Enter Product Category");
		String type=scanner.next();
		
		
		System.out.println("Enter Product Manifacturing date");
		String productDate=scanner.next();
		
		//scanner.close();
		Product product=new Product(id,name,productDate,price,type);
		
		return product;
			
		
		
	}


public boolean updateProductInfo(Product product)
{
	return dao.updateProduct(product);
}


public Product getProductById(int productId)
{
	return dao.getProductById(productId);
	
	
}


public boolean deleteProductById(int id) {
	// TODO Auto-generated method stub
	return dao.deleteProductById(id);
}




public boolean addProduct(Product product) {
	// TODO Auto-generated method stub
	return dao.saveProduct(product);
}
}