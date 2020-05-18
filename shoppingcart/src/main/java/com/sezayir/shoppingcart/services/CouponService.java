package com.sezayir.shoppingcart.services;

import static com.sezayir.shoppingcart.campaign.DiscountTypeEnum.RATE;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

import com.sezayir.shoppingcart.model.Coupon;

/**
 * 
 * @author sezayir
 *
 */
@Service
public class CouponService {

	public Coupon getCoupon() {
		return new Coupon(new BigDecimal(100.0), new BigDecimal(10.0), RATE);

	}

}
