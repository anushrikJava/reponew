package com.jbk.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private int productId;
	
	@Column(unique=true )
	private String productName;
	
	private String productMfg;
	private double productPrice;
	private String productCategory;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int productId, String productName, String productMfg, double productPrice, String productCategory) {
		super();
		System.out.println(productMfg);
		this.productId = productId;
		this.productName = productName;
		this.productMfg = productMfg;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productMfg=" + productMfg
				+ ", productPrice=" + productPrice + ", productCategory=" + productCategory + "]";
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductMfg() {
		return productMfg;
	}
	public void setProductMfg(String productMfg) {
		this.productMfg = productMfg;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	
	

}
