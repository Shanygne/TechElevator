package com.techelevator.ssg.model.store;

public class Product {

	private Long id;
	private String name;
	private String description;
	private DollarAmount price;
	private String imageName;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	<small>

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

	public DollarAmount getPrice() {
		return price;
	}

	public void setPrice(DollarAmount price) {
		this.price = price;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
