package com.techsophy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techsophy.model.Offer;
import com.techsophy.repository.OfferRepository;

@RestController    
@RequestMapping(path="/offer") 
public class OfferController {

	@Autowired 
	private OfferRepository offerRepository;
	
	@RequestMapping(path="/{type}",method = RequestMethod.GET)
	public @ResponseBody List<Offer> getOffer (@PathVariable String type) {	
		return offerRepository.findByType(type);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Offer saveOffer (@RequestBody Offer offer) {	
		return offerRepository.save(offer);
	}
}
