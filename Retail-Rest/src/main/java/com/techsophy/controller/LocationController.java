package com.techsophy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techsophy.model.Location;
import com.techsophy.repository.LocationRepository;

@RestController    
@RequestMapping(path="/location") 
public class LocationController {

	@Autowired 
	private LocationRepository LocationRepository;
	
	@RequestMapping(path="/{type}",method = RequestMethod.GET)
	public @ResponseBody List<Location> getLocation (@PathVariable Sort type) {	
		return LocationRepository.findAll(type);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Location saveLocation (@RequestBody Location location) {	
		return LocationRepository.save(location);
	}
}
