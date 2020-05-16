package com.sezayir.shoppingcart.cart;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sezayir.shoppingcart.controller.ShoppingCartController;
import com.sezayir.shoppingcart.model.Product;
import com.sezayir.shoppingcart.model.ShoppingCartItem;

/**
 * 
 * @author sezayir
 *
 */
@Component
public class ShoppingCart {

	@Autowired
	ShoppingCartItem shoppingCartItem;

	private final List<ShoppingCartItem> items = new ArrayList<>();
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
	
	public List<ShoppingCartItem> getItems() {
		return items;
	}


	/**
	 * 
	 * @param product
	 * @param quantity
	 */
	public void addItems(Product product, int quantity) {
		shoppingCartItem.setProduct(product);
		shoppingCartItem.setQuantity(quantity);
		items.add(shoppingCartItem);
		logger.info(quantity +" " +product.getTitle()+ " from category " + product.getCategory().getTitle()+ " added to basket!");
		
	}

}
