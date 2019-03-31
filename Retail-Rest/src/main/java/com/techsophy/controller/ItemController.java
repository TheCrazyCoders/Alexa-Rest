package com.techsophy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techsophy.model.Item;
import com.techsophy.model.ItemVariant;
import com.techsophy.model.Location;
import com.techsophy.model.Offer;
import com.techsophy.repository.ItemRepository;
import com.techsophy.repository.ItemVariantRepository;

@RestController
@RequestMapping(path="/item")
public class ItemController {
	
	@Autowired 
	private ItemRepository itemRepository;
	
	@Autowired
	private ItemVariantRepository itemVariantRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Item> getAllItems () {
		
		return itemRepository.findAll();
	}
	
	@RequestMapping(path="/{item}",method = RequestMethod.GET)
	public @ResponseBody List<ItemVariant> getAllVariant (@PathVariable String item) {
		
		Item itemObj = itemRepository.findByNameIgnoreCase(item);
		List<ItemVariant> itemVariant = itemVariantRepository.findByItemId(itemObj.getId());
		return itemVariant;
	}
	
	@RequestMapping(path="/{item}/location",method = RequestMethod.GET)
	public @ResponseBody List<Location> getLocation (@PathVariable String item) {
		
		List<ItemVariant> items = itemVariantRepository.findByItemId(itemRepository.findByNameIgnoreCase(item).getId());
		List<Location> locations = new ArrayList<>();
		for(ItemVariant variant : items){
			locations.add(variant.getLocation());
		}
		return locations;
	}
	
	@RequestMapping(path="/variant", method = RequestMethod.POST)
	public @ResponseBody ItemVariant saveItemVariant (@RequestBody ItemVariant item) {	
		return itemVariantRepository.save(item);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Item saveItem (@RequestBody Item item) {	
		return itemRepository.save(item);
	}
}
