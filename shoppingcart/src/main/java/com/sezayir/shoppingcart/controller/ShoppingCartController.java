package com.sezayir.shoppingcart.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sezayir.shoppingcart.model.Category;
import com.sezayir.shoppingcart.model.Product;
import com.sezayir.shoppingcart.model.ShoppingCartItem;
import com.sezayir.shoppingcart.services.ShoppingService;

@RestController
@RequestMapping("/basket")
public class ShoppingCartController {

	@Autowired
	ShoppingService shoppingService;
	
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

	@RequestMapping("/items")
	public ResponseEntity<List<ShoppingCartItem>> getBasketItems() {
		logger.info("getBasketItems end point is called...");
		return new ResponseEntity<List<ShoppingCartItem>>(shoppingService.getItems(), HttpStatus.OK);
	}

	@RequestMapping("/add")
	public ResponseEntity<Product> addBasketItems() {
		logger.info("addBasketItems end point is called...");
		Category category = new Category("Elecktronic", null);
		Product product = new Product("Printer", new BigDecimal(250.00), category);
		shoppingService.addItems(product, 2);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

}
