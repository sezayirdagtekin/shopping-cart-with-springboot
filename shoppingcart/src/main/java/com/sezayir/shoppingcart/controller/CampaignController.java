package com.sezayir.shoppingcart.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sezayir.shoppingcart.campaign.Campaign;
import com.sezayir.shoppingcart.services.CampaignService;

/**
 * 
 * @author sezayir
 *
 */
@RestController
@RequestMapping("/campaign")
public class CampaignController {

	@Autowired
	CampaignService campaignService;

	private static final Logger logger = LoggerFactory.getLogger(CampaignController.class);

	@RequestMapping("/create")
	public ResponseEntity<Object> createCampaing() {
		logger.info("createcampaing end point is called...");
		campaignService.createCampaigns();
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping("/list")
	public ResponseEntity<HashMap<String, Campaign>> getCampaigns() {
		logger.info("getCampaigns end point is called...");
		return new ResponseEntity<>(campaignService.getCamapigns(), HttpStatus.OK);
	}

}
