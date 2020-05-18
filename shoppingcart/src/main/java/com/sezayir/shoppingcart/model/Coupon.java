package com.sezayir.shoppingcart.model;

import java.math.BigDecimal;

import com.sezayir.shoppingcart.campaign.DiscountTypeEnum;

public class Coupon {
	
	private BigDecimal minAmount;
	private BigDecimal discountRate;
	DiscountTypeEnum discountType;
	

	public Coupon(BigDecimal minAmount, BigDecimal discountRate, DiscountTypeEnum discountType) {
		this.minAmount = minAmount;
		this.discountRate = discountRate;
		this.discountType = discountType;
	}
	
	public BigDecimal getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(BigDecimal minAmount) {
		this.minAmount = minAmount;
	}
	public BigDecimal getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}
	public DiscountTypeEnum getDiscountType() {
		return discountType;
	}
	public void setDiscountType(DiscountTypeEnum discountType) {
		this.discountType = discountType;
	}

	@Override
	public String toString() {
		return "Coupon [minAmount=" + minAmount + ", discountRate=" + discountRate + ", discountType=" + discountType
				+ "]";
	}
	

}
