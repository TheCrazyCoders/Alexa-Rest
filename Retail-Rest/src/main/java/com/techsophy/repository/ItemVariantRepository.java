package com.techsophy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsophy.model.ItemVariant;

public interface ItemVariantRepository extends JpaRepository<ItemVariant, Long>{
	List<ItemVariant> findByItemId(Long itemId);
}
