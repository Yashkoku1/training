package com.yk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	private int  code;
	@Column(name="pname" , length = 30)
	private String name;
	
	private double price;
	@Column(length=20)
	private String category;
	
	 public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int code, String name, double price, String category) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

}
