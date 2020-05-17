package com.sezayir.shoppingcart.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author sezayir
 *
 */
@Component
public class ShoppingCartItem {
	private int quantity;

	@Autowired
	private Product product;

	public ShoppingCartItem() {

	}

	public ShoppingCartItem(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
