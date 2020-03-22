package com.techelevator.ssg.model.store;

import java.util.List;

public interface ProductDao {

	public List<Product> getAllProducts();

	public Product getProductById(Long productId);
}
