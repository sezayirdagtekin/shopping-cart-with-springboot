package com.sezayir.shoppingcart.controller;

import static com.sezayir.shoppingcart.util.Constants.FOOD;
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
import com.sezayir.shoppingcart.coupon.Coupon;
import com.sezayir.shoppingcart.model.Category;
import com.sezayir.shoppingcart.model.Product;
import com.sezayir.shoppingcart.model.ShoppingCartItem;
import com.sezayir.shoppingcart.services.CampaignService;
import com.sezayir.shoppingcart.services.CouponService;
import com.sezayir.shoppingcart.services.ShoppingService;;

@RestController
@RequestMapping("/basket")
public class ShoppingCartController {

	@Autowired
	ShoppingService shoppingService;

	@Autowired
	CampaignService campaignService;
	
	@Autowired
	CouponService couponService;
	

	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

	@RequestMapping("/list")
	public ResponseEntity<List<ShoppingCartItem>> getBasketItems() {
		logger.info("getBasketItems end point is called...");
		return new ResponseEntity<List<ShoppingCartItem>>(shoppingService.getItems(), HttpStatus.OK);
	}

	@RequestMapping("/add")
	public ResponseEntity<Product> addBasketItems() {
		logger.info("addBasketItems end point is called...");
		Category category = new Category(FOOD, null);
		Product product = new Product("Nutella", new BigDecimal(40.00), category);
		shoppingService.addItems(product, 5);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}

	
	@RequestMapping("/discount")
	public ResponseEntity<List<ShoppingCartItem>> getDiscountedBasketItems() {
		logger.info("getDiscountedBasketItems end point is called...");
		 campaignService.createCampaigns();
		HashMap<String, Campaign> campaignMap = campaignService.getCamapigns();
		Campaign campaign1 = campaignMap.get("DSC%20");
		Campaign campaign2 = campaignMap.get("DSC%50");
		List<ShoppingCartItem> discount=shoppingService.applyDiscount(campaign1, campaign2);
		return new ResponseEntity<List<ShoppingCartItem>>(discount, HttpStatus.OK);
	}
	
	@RequestMapping("/applycoupon")
	public ResponseEntity<Object> applycoupon() {
		logger.info("applycoupon end point is called...");
		Coupon coupon=couponService.getCoupon();
		shoppingService.applyCoupon(coupon);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
