package com.sezayir.shoppingcart.campaign;

import java.math.BigDecimal;

import com.sezayir.shoppingcart.model.Category;

/**
 * 
 * @author sezayir
 *
 */
public class Campaign {

	private Category category;
	private int numberOfItems;
	private BigDecimal discountValue;
	private DiscountTypeEnum discountType;

	public Campaign() {

	}

	public Campaign(Category category, int numberOfItems, BigDecimal discountValue, DiscountTypeEnum discountType) {
		this.category = category;
		this.numberOfItems = numberOfItems;
		this.discountValue = discountValue;
		this.discountType = discountType;
	}

	public BigDecimal getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(BigDecimal discountValue) {
		this.discountValue = discountValue;
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

	@Override
	public String toString() {
		return "Campaign [category=" + category + ", numberOfItems=" + numberOfItems + ", dicountValue=" + discountValue
				+ ", discountType=" + discountType + "]";
	}

	
}
