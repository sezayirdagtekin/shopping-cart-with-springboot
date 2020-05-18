package com.sezayir.shoppingcart.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sezayir.shoppingcart.campaign.Campaign;
import com.sezayir.shoppingcart.model.Category;
import com.sezayir.shoppingcart.model.Coupon;
import com.sezayir.shoppingcart.model.Product;
import com.sezayir.shoppingcart.model.ShoppingCartItem;
import com.sezayir.shoppingcart.services.CampaignService;
import com.sezayir.shoppingcart.services.CouponService;
import com.sezayir.shoppingcart.services.ShoppingService;
import static com.sezayir.shoppingcart.util.Constants.ELECTRONIC;
import static com.sezayir.shoppingcart.util.Constants.BOOK;;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	ShoppingService shoppingService;

	@Autowired
	CampaignService campaignService;
	
	@Autowired
	CouponService couponService;

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);


	@RequestMapping("/generate")
	public ResponseEntity<String> generate() {
		logger.info("generare end point is called...");
		//Create Category
		Category category1 = new Category(ELECTRONIC, null);
		Category category2 = new Category(BOOK, null);
		
		Product product1 = new Product("Printer", new BigDecimal(250.00), category1);
		shoppingService.addItems(product1, 5);
		
		Product product2 = new Product("Samsung TV", new BigDecimal(500.00), category1);
		shoppingService.addItems(product2, 4);	
		Product product3 = new Product("Java Fundamentels", new BigDecimal(100.00), category2);
		shoppingService.addItems(product3, 1);
		
		//Create campaigns
		campaignService.createCampaigns();
		//Get campaigns
		HashMap<String, Campaign> campaignMap = campaignService.getCamapigns();
		Campaign campaign1 = campaignMap.get("DSC%20");
		Campaign campaign2 = campaignMap.get("DSC%50");
		List<ShoppingCartItem> discount=shoppingService.applyDiscount(campaign1, campaign2);

		//Apply coupon
		Coupon coupon=couponService.getCoupon();
		shoppingService.applyCoupon(coupon);
		shoppingService.calculateDeliveryCost();
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}




}
