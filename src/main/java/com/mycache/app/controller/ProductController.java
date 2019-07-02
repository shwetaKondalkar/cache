package com.mycache.app.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycache.app.model.Product;
import com.mycache.app.service.ProductService;

@RestController
public class ProductController {

	private static final Logger LOGGER = LogManager.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") String id) {
        LOGGER.info("getProduct called for id {}", id);
        return productService.getProduct(id);
    }

    
    @PostMapping()
    public Product updateProduct( @RequestBody Product product) {
        LOGGER.info("updateProduct called for id {}");
       // product.setId(id);
        
        return productService.updateProduct(product);
    }
    
    
    @GetMapping()
    public List<Product> getAll(){
    	return productService.getProductList();
    }
}