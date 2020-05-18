package com.sezayir.shoppingcart.cart;

import static com.sezayir.shoppingcart.campaign.DiscountTypeEnum.AMOUNT;
import static com.sezayir.shoppingcart.campaign.DiscountTypeEnum.RATE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.sezayir.shoppingcart.campaign.Campaign;
import com.sezayir.shoppingcart.controller.ShoppingCartController;
import com.sezayir.shoppingcart.delivery.DeliverCostCalulator;
import com.sezayir.shoppingcart.model.Category;
import com.sezayir.shoppingcart.model.Coupon;
import com.sezayir.shoppingcart.model.Product;
import com.sezayir.shoppingcart.model.ShoppingCartItem;

/**
 * O
 * 
 * @author sezayir
 *
 */
@Component
public class ShoppingCart {

	ShoppingCartItem shoppingCartItem;
	private BigDecimal totalAmount;

	private final List<ShoppingCartItem> items = new ArrayList<>();
	private List<ShoppingCartItem> discountedItems;
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

	public List<ShoppingCartItem> getItems() {
		return items;
	}

	public List<ShoppingCartItem> getDiscountedItems() {
		return discountedItems;
	}

	/**
	 * 
	 * @param product
	 * @param quantity
	 */
	public void addItems(Product product, int quantity) {
		ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
		shoppingCartItem.setProduct(product);
		shoppingCartItem.setQuantity(quantity);
		items.add(shoppingCartItem);
		logger.info(quantity + " " + product.getTitle() + " from category " + product.getCategory().getTitle()+ " added to basket!");

	}

	/**
	 * 
	 * @param campaign
	 * @return
	 */
	public List<ShoppingCartItem> applyDiscount(Campaign... campaign) {

		Map<Category, Integer> map = getItems().stream().collect(
				Collectors.groupingBy(s -> s.getProduct().getCategory(), Collectors.summingInt(s -> s.getQuantity())));

		discountedItems = getItems();

		for (Campaign c : campaign) {
			Integer totalNumberOfProductInCategory = map.get(c.getCategory());
			if (totalNumberOfProductInCategory != null && totalNumberOfProductInCategory >= c.getNumberOfItems())
				if (RATE.equals(c.getDiscountType())) {
					discountedItems.forEach(f -> {
						if (f.getProduct().getCategory().equals(c.getCategory())) {
							f.getProduct().setPrice(f.getProduct().getPrice().multiply(multiplierFactor(c)));
						}
					});

				} else if (AMOUNT.equals(c.getDiscountType())) {
					discountedItems.forEach(
							f -> f.getProduct().setPrice(f.getProduct().getPrice().subtract(c.getDiscountValue())));

				}
		}

		return discountedItems;

	}

	private BigDecimal multiplierFactor(Campaign c) {
		return BigDecimal.ONE.subtract(c.getDiscountValue().divide(new BigDecimal(100.0)));
	}

	public void applyCoupon(Coupon coupon) {

		List<ShoppingCartItem> cart = getDiscountedItems();
		totalAmount = cart.stream().map(s -> s.getProduct().getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
		if (totalAmount.compareTo(coupon.getMinAmount()) > 0) {
			logger.info("Before coupon applied total is:" + totalAmount);
			totalAmount = totalAmount.multiply(BigDecimal.ONE.subtract(coupon.getDiscountRate().divide(new BigDecimal(100.0))));
			logger.info("After coupon applied total is:" + totalAmount);
		}
	}

	public void calculateDeliveryCost() {
		DeliverCostCalulator cal = new DeliverCostCalulator(new BigDecimal(10.0), new BigDecimal(5.0),
				new BigDecimal(2.0));
		BigDecimal totalDeliveryCost = cal.calculate(this);
		logger.info("Total delivery cost is:" + totalDeliveryCost);
	}

}
