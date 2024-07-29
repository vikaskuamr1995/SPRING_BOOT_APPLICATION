package com.Product.App.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long productId;
	
	String productName;
	
	String description;
	
	int amount;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", amount=" + amount + "]";
	}

	public Product() {
		
	}

	public Product(long productId, String productName, String description, int amount) {
		
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.amount = amount;
	}
	
	
}
