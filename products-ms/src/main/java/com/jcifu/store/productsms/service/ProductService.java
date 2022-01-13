package com.jcifu.store.productsms.service;

import java.util.List;
import java.util.Optional;

import com.jcifu.store.productsms.model.Product;

public interface ProductService {
    
    List<Product> getProducts();
    
    Optional<Product> getProduct(Integer productCode);
    
    Optional<Product> updateProduct(Product product, Integer productCode);

    Product saveProduct(Product product);

    String deleteProduct(Integer productCode);
}
