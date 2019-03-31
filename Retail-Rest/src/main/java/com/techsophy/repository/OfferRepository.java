package com.techsophy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsophy.model.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long>{
	List<Offer> findByType(String type);
}
