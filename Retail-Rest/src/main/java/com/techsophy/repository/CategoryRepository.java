package com.techsophy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsophy.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
