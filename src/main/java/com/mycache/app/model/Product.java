package com.mycache.app.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
    private String ean;
    private String name;
    
        
	public Product(String id, String ean, String name) {
		super();
		this.id = id;
		this.ean = ean;
		this.name = name;
	}

}