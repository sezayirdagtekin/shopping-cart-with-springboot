package com.sezayir.shoppingcart.model;

import java.math.BigDecimal;

public class Product {
	
	private long id;
	private String title;
	private BigDecimal price;
	
	public Product(long id, String title, BigDecimal price, Category category) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.category = category;
	}
	private Category category;

	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	

}
