package com.yk.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.util.ProductNotFoundException;
import com.yk.dto.ProductDto;
import com.yk.entity.Product;
import com.yk.service.ProductService;
import com.yk.service.ProductServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/prod")
public class ProductController {
	
	@Autowired
		private ProductService service;
		
		@PostMapping(value="/add", consumes="application/json")
		public ResponseEntity<String> add(@RequestBody @Valid ProductDto p){
			service.save(p);
			return new ResponseEntity<String>("Product added.", HttpStatus.OK);
		}
		
		@GetMapping(value="/list", produces="application/json")
		public ResponseEntity<List<Product>> list(){
		
			return new ResponseEntity<List<Product>>(service.list(), HttpStatus.OK);
		}
		
		@GetMapping(value="/{code}", produces="application/json")
		public ResponseEntity<Product> find(@PathVariable int code) throws ProductNotFoundException{
		
			return new ResponseEntity<Product>(service.getbyCode(code), HttpStatus.OK);
		}
		
		@DeleteMapping(value="/delete/{code}")
		public ResponseEntity<String> remove(@PathVariable int code) throws ProductNotFoundException{
		
			service.delete(code);
			return new ResponseEntity<String>("Product deleted.", HttpStatus.OK);
		}
		
		@GetMapping(value="/listByCategory/{cat}", produces="application/json")
		public ResponseEntity<List<Product>> getByCategory(@PathVariable String cat) throws ProductNotFoundException{
		
			return new ResponseEntity<List<Product>>(service.listByCategory(cat), HttpStatus.OK);
		}
		
		@GetMapping(value="/listByPrice/{min}/{max}", produces="application/json")
		public ResponseEntity<List<Product>> getByPrice(@PathVariable double min, @PathVariable double max) throws ProductNotFoundException{
		
			return new ResponseEntity<List<Product>>(service.listByPriceRange(min, max), HttpStatus.OK);
		}
		
		@GetMapping(value="/listByPriceHighToLow", produces="application/json")
		public ResponseEntity<List<Product>> getByPriceHighToLow(){
		
			return new ResponseEntity<List<Product>>(service.listByPriceLowToHigh(), HttpStatus.OK);
		}
	
	

}
