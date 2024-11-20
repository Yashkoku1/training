package com.yk.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yk.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	//@Query("FROM Product Where price BETWEEN :min AND :max")
	List<Product> findByPriceBetween(double min, double max);
	
	List<Product> findByCategory(String category);
	

	//@Query("FROM Product ORDER BY price")
	List<Product> findAllByOrderByPriceDesc();
	

}
