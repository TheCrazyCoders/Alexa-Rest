package com.techsophy.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Item {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	
	private String name;
	
	private String description;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="category_id")
	@JsonBackReference
	private Category category;
	
	@OneToMany(mappedBy="item")
	@JsonManagedReference
	private List<ItemVariant> variants;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ItemVariant> getVariants() {
		return variants;
	}

	public void setVariants(List<ItemVariant> variants) {
		this.variants = variants;
	}

}
