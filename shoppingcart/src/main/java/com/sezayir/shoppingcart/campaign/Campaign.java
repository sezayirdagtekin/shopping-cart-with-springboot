package com.sezayir.shoppingcart.campaign;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sezayir.shoppingcart.model.Category;

/**
 * 
 * @author sezayir
 *
 */
@Component
public class Campaign {

	@Autowired
	private Category category;
	private int numberOfItems;
	private BigDecimal dicountValue;
	private DiscountTypeEnum discountType;

	public Campaign() {

	}

	public Campaign(Category category, int numberOfItems, BigDecimal dicountValue, DiscountTypeEnum discountType) {
		this.category = category;
		this.numberOfItems = numberOfItems;
		this.dicountValue = dicountValue;
		this.discountType = discountType;
	}

	public BigDecimal getDicountValue() {
		return dicountValue;
	}

	public void setDicountValue(BigDecimal dicountValue) {
		this.dicountValue = dicountValue;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public DiscountTypeEnum getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DiscountTypeEnum discountType) {
		this.discountType = discountType;
	}

}
