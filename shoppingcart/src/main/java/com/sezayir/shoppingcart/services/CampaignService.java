package com.sezayir.shoppingcart.services;

import java.math.BigDecimal;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.sezayir.shoppingcart.campaign.Campaign;
import com.sezayir.shoppingcart.campaign.DiscountTypeEnum;
import com.sezayir.shoppingcart.controller.ShoppingCartController;
import com.sezayir.shoppingcart.model.Category;
import static com.sezayir.shoppingcart.util.Constants.BOOK;
import static com.sezayir.shoppingcart.util.Constants.ELECTRONIC;
import static com.sezayir.shoppingcart.util.Constants.FOOD;


/**
 * 
 * @author sezayir
 *
 */
@Service
public class CampaignService {

	private HashMap<String, Campaign> campaignMap = new HashMap<>();
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

	public void createCampaigns() {
		Category food = new Category(FOOD, null);
		Category electronic = new Category(ELECTRONIC, null);
		Category book = new Category(BOOK, null);

		Campaign campaign1 = new Campaign(electronic, 3, new BigDecimal(20.0), DiscountTypeEnum.RATE);
		Campaign campaign2 = new Campaign(food, 5, new BigDecimal(50.0), DiscountTypeEnum.RATE);
		Campaign campaign3 = new Campaign(book, 2, new BigDecimal(5.0), DiscountTypeEnum.AMOUNT);

		campaignMap.put("DSC%20", campaign1);
		campaignMap.put("DSC%50", campaign2);
		campaignMap.put("DSC-5TL", campaign3);
	    logger.info("3 Campaigs are created");
		logger.info(campaign1.toString());
		logger.info(campaign2.toString());
		logger.info(campaign3.toString());
	
	}

	public HashMap<String, Campaign> getCamapigns() {
		return campaignMap;
	}

}
