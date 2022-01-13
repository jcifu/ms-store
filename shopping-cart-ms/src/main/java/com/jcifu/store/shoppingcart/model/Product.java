package com.jcifu.store.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Product {
    
	@Id
	@Column
	private Integer productCode;
	
	@Column
	private String productName;
	
	@Column
	private Integer quantity;
	
	@Column
	private Integer price;
	
	// private Cart cart;
    
}
