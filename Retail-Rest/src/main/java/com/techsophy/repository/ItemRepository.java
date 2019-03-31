package com.techsophy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsophy.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	Item findByNameIgnoreCase(String name);

	//Item equalsIgnoreCase(String item);
}
