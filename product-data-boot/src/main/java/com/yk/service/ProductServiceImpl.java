package com.yk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.dto.ProductDto;
import com.yk.entity.Product;
import com.yk.repo.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo repo;
	@Override
	public void save(ProductDto p) {
		// TODO Auto-generated method stub
	 Product po = new Product();
	 
	 po.setCode(p.getCode());
	 po.setName(p.getName());
	 po.setPrice(p.getPrice());
	 po.setCategory(p.getCategory());
	 
	 repo.save(po);
	 
		
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product getbyCode(int code) {
		// TODO Auto-generated method stub
	
		return repo.findById(code).get();
	}

	@Override
	public void delete(int code) {
		// TODO Auto-generated method stub
		repo.deleteById(code);

	}

	@Override
	public List<Product> listByCategory(String cat) {
		// TODO Auto-generated method stub
		return repo.findByCategory(cat);
	}

	@Override
	public List<Product> listByPriceRange(double min, double max) {
		// TODO Auto-generated method stub
		return repo.findByPriceBetween(min, max);
	}

	@Override
	public List<Product> listByPriceLowToHigh() {
		// TODO Auto-generated method stub
		return repo.findAllByOrderByPriceDesc();
	}

}
