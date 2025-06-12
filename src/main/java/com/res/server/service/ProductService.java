package com.res.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.res.server.data.Product;

@Service
public class ProductService {
	private List<Product> list = new ArrayList<>();
	
	public ProductService(){
		list.add(new Product(UUID.randomUUID().toString(), "Demo Product 1", "This is demo product", 3252.242));

	}
	
	public Product add(Product product){
		product.setProductId(UUID.randomUUID().toString());
		list.add(product);
		return product;
	}
	
	public List<Product> getAll(){
		return list;
	}
	
	public void delete(String id){
		list.removeIf(product -> product.getProductId().equals(id));
	}
	
}
