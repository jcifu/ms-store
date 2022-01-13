package com.jcifu.store.shoppingcart.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shoppingcarts")
public class Cart implements Serializable{
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer cartId;
	
	@Column
	private Integer productCode;

	@Column
	private String productName;

	// @Column
	// private Integer customerId;

	@Column
	private Integer quantity;

	@Column
	private Integer price;

	@Column
	private Integer totalSale;

	@OneToMany (mappedBy = "productCode", targetEntity = Product.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> products;
}
