package com.springboot.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	private Integer productID;
	private String productCategory;
	private String product;
	private Integer productSales;
	private String productQuater;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer productID, String productCategory, String product, Integer productSales, String productQuater) {
		super();
		this.productID = productID;
		this.productCategory = productCategory;
		this.product = product;
		this.productSales = productSales;
		this.productQuater = productQuater;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Integer getProductSales() {
		return productSales;
	}
	public void setProductSales(Integer productSales) {
		this.productSales = productSales;
	}
	public String getProductQuater() {
		return productQuater;
	}
	public void setProductQuater(String productQuater) {
		this.productQuater = productQuater;
	}
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productCategory=" + productCategory + ", product=" + product
				+ ", productSales=" + productSales + ", productQuater=" + productQuater + "]";
	}
	
}
