package com.sezayir.shoppingcart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sezayir.shoppingcart.cart.ShoppingCart;
import com.sezayir.shoppingcart.model.Product;
import com.sezayir.shoppingcart.model.ShoppingCartItem;

/**
 * 
 * @author sezayir
 *
 */
@Service
public class ShoppingService {
	
	@Autowired
	ShoppingCart shoppingCart;
	
	public void addItems(Product product, int quantity) {
		shoppingCart.addItems(product, quantity);
	}
	
	public List<ShoppingCartItem> getItems() {
		return shoppingCart.getItems();
	}

}