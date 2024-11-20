package com.yk.service;

import java.util.List;

import com.yk.dto.ProductDto;
import com.yk.entity.Product;

public interface ProductService {

	void save(ProductDto p);
	
	List<Product> list();
	
	Product getbyCode(int code);
	
	void delete(int code);
	
	List<Product> listByCategory(String cat);
	
	List<Product> listByPriceRange(double min , double max);
	
	 List<Product> listByPriceLowToHigh();
}
