package com.res.server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.res.server.data.Product;
import com.res.server.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin("*")
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	//create product
	@PostMapping
	public Product createProduct(@RequestBody Product product)
	{
		return productService.add(product);
	}
	//get product
	@GetMapping
	public List<Product> getAll(){
		return productService.getAll();
	}
	
	//delete product
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable String id)
	{
		productService.delete(id);
	}
}
