package com.jcifu.store.productsms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "products")
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
	private Integer productCode;
   
    @Column
	private String productName;
   
    @Column
	private String brand;
   
    @Column
	private Integer stock;
   
    @Column
	private Integer price;
   
    @Column
	private String description;

    @Column
    private Integer categoryId;
    
}
