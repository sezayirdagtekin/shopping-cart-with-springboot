package com.sezayir.shoppingcart.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sezayir.shoppingcart.campaign.Campaign;
import com.sezayir.shoppingcart.controller.ShoppingCartController;
import com.sezayir.shoppingcart.model.Category;
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
	private  List<ShoppingCartItem> discountedItems;
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

	/**
	 * 
	 * @param campaign
	 * @return
	 */
	public List<ShoppingCartItem> applyDiscounst(Campaign... campaign) {
		
		Map<Category, List<Product>> categoryProducts = getItems().stream().map(s -> s.getProduct())
				.collect(Collectors.groupingBy(Product::getCategory));
		/*
		  for (Campaign c: campaign) {
	            System.out.print(c.getDicountValue() + " "); 
	    } 
		*/
		return discountedItems;
	}


}
