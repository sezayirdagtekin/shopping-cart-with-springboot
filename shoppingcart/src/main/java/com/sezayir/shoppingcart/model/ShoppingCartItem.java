package com.sezayir.shoppingcart.model;

import org.springframework.stereotype.Component;

/**
 * 
 * @author sezayir
 *
 */
@Component
public class ShoppingCartItem {
	private int quantity;
	private Product product;

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
