package com.sezayir.shoppingcart.delivery;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import com.sezayir.shoppingcart.cart.ShoppingCart;
import com.sezayir.shoppingcart.model.Product;

public class DeliverCostCalulator {

	private BigDecimal costPerProduct;
	private BigDecimal costPerDelivery;
	private BigDecimal fixedCost;

	public BigDecimal getCostPerProduct() {
		return costPerProduct;
	}

	public void setCostPerProduct(BigDecimal costPerProduct) {
		this.costPerProduct = costPerProduct;
	}

	public BigDecimal getCostPerDelivery() {
		return costPerDelivery;
	}

	public void setCostPerDelivery(BigDecimal costPerDelivery) {
		this.costPerDelivery = costPerDelivery;
	}

	public BigDecimal getFixedCost() {
		return fixedCost;
	}

	public void setFixedCost(BigDecimal fixedCost) {
		this.fixedCost = fixedCost;
	}

	public DeliverCostCalulator(BigDecimal costPerProduct, BigDecimal costPerDelivery, BigDecimal fixedCost) {
		this.costPerProduct = costPerProduct;
		this.costPerDelivery = costPerDelivery;
		this.fixedCost = fixedCost;
	}

	public BigDecimal calculate(ShoppingCart cart) {
		int numberOfDeliveries = cart.getItems().stream().map(s -> s.getProduct())
				.collect(Collectors.groupingBy(Product::getCategory, Collectors.counting())).size();
		
		Long numOfProducts = cart.getItems().stream().map(s -> s.getProduct()).collect(Collectors.counting());
		
		BigDecimal amountCostPerDelivery = this.getCostPerDelivery().multiply(new BigDecimal(numberOfDeliveries));
		BigDecimal amountCostPerProduct = this.getCostPerProduct().multiply(new BigDecimal(numOfProducts));
		
		return amountCostPerDelivery.add(amountCostPerProduct).add(this.getFixedCost());

	}

}
