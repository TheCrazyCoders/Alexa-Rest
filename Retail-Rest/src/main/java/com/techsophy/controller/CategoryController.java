package com.techsophy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techsophy.model.Category;
import com.techsophy.repository.CategoryRepository;

@RestController    
@RequestMapping(path="/category") 
public class CategoryController {

	@Autowired 
	private CategoryRepository categoryRepository;
	
	@RequestMapping(path="/{type}",method = RequestMethod.GET)
	public @ResponseBody Category getCategory (@PathVariable Long id) {	
		return categoryRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategory () {	
		return categoryRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Category saveCategory (@RequestBody Category category) {	
		return categoryRepository.save(category);
	}
}
