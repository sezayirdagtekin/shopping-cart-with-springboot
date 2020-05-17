package com.sezayir.shoppingcart.services;

import java.math.BigDecimal;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sezayir.shoppingcart.campaign.Campaign;
import com.sezayir.shoppingcart.campaign.DiscountTypeEnum;
import com.sezayir.shoppingcart.model.Category;

/**
 * 
 * @author sezayir
 *
 */
@Service
public class CampaignService {

	private HashMap<String, Campaign> campaignMap = new HashMap<>();

	public void createCampaigns() {
		Category food = new Category("Food", null);
		Category electronic = new Category("Electronic", null);
		Category book = new Category("Book", null);

		Campaign campaign1 = new Campaign(electronic, 3, new BigDecimal(20.0), DiscountTypeEnum.RATE);
		Campaign campaign2 = new Campaign(food, 5, new BigDecimal(50.0), DiscountTypeEnum.RATE);
		Campaign campaign3 = new Campaign(book, 2, new BigDecimal(5.0), DiscountTypeEnum.AMOUNT);

		campaignMap.put("DSC%20", campaign1);
		campaignMap.put("DSC%50", campaign2);
		campaignMap.put("DSC-5TL", campaign3);

	}

	public HashMap<String, Campaign> getCamapigns() {
		return campaignMap;
	}

}
