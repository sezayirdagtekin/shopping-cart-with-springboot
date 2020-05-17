package com.sezayir.shoppingcart.cart;

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
import com.sezayir.shoppingcart.model.Category;
import com.sezayir.shoppingcart.model.Product;
import com.sezayir.shoppingcart.model.ShoppingCartItem;
import static com.sezayir.shoppingcart.campaign.DiscountTypeEnum.AMOUNT;
import static com.sezayir.shoppingcart.campaign.DiscountTypeEnum.RATE;

/**
 * O
 * 
 * @author sezayir
 *
 */
@Component
public class ShoppingCart {

	ShoppingCartItem shoppingCartItem;

	private final List<ShoppingCartItem> items = new ArrayList<>();
	private List<ShoppingCartItem> discountedItems;
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
		ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
		shoppingCartItem.setProduct(product);
		shoppingCartItem.setQuantity(quantity);
		items.add(shoppingCartItem);
		logger.info(quantity + " " + product.getTitle() + " from category " + product.getCategory().getTitle()
				+ " added to basket!");

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

}
