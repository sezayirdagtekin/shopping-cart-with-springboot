package com.sezayir.shoppingcart.model;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Component;

/**
 * 
 * @author sezayir
 *
 */
@Component
public class Product {

	private String uuid;
	private String title;
	private BigDecimal price;
	private Category category;

	public Product() {

	}

	public Product(String title, BigDecimal price, Category category) {
		this.uuid = UUID.randomUUID().toString();
		this.title = title;
		this.price = price;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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
