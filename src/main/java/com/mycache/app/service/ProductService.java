package com.mycache.app.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mycache.app.model.Product;

@Service
public class ProductService {
	private static final Logger LOGGER = LogManager.getLogger(ProductService.class);

	@Cacheable(value = "products",key = "#p0")
    public Product getProduct(String id) {
        LOGGER.info("getProduct called for id {}", id);
        return new Product(id, "0826663141405", "The Angry Beavers: The Complete Series");
    }

	@CachePut(value = "products",key = "#p0.id")
    public Product  updateProduct(Product product) {
        LOGGER.info("updateProduct called for id {}", product.getId());
        //do nothing, we just simulate the update
        
		return getProduct(product.getId());
    }
    
    
    public List<Product> getProductList() {
        LOGGER.info("get Product List")   ;
        Product p1= new Product("1", "0826663141405", "The Angry Beavers: The Complete Series");
        Product p2= new Product("1", "0826663141405", "The Angry Beavers: The Complete Series");
        Product p3= new Product("1", "0826663141405", "The Angry Beavers: The Complete Series");
        Product p4= new Product("1", "0826663141405", "The Angry Beavers: The Complete Series");
        Product p5= new Product("1", "0826663141405", "The Angry Beavers: The Complete Series");
        List<Product> productList = new ArrayList<Product>();
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
		return productList;
    }
}
