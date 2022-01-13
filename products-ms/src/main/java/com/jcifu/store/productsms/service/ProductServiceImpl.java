package com.jcifu.store.productsms.service;

import java.util.List;
import java.util.Optional;

import com.jcifu.store.productsms.model.Product;
import com.jcifu.store.productsms.repository.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getProducts() {
        List<Product> productList = productRepo.findAll();
        return productList;
    }

    @Override
    public Optional<Product> getProduct(Integer productCode) {
        Optional<Product> productOptional = productRepo.findById(productCode);
        return productOptional;
    }

    @Override
    public Optional<Product> updateProduct(Product product, Integer productCode) {

        Optional<Product> productOptional = productRepo.findById(productCode);
        Product p = productOptional.get();
        
        if(productOptional.isPresent()){
            p.setProductCode(p.getProductCode());
            p.setProductName(p.getProductName());
            p.setBrand(p.getBrand());
            p.setStock(p.getStock());
            p.setPrice(p.getPrice());
            p.setDescription(p.getDescription());
            
            productRepo.save(p);
        }
        
        return productOptional;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public String deleteProduct(Integer productCode) {

        if (productCode != null) {

            if (productRepo.existsById(productCode)) {
                productRepo.deleteById(productCode);
                return ("Producto " + productCode + " eliminado");
            } else {
                
                return "Código de producto no existe. Ingrese código nuevamente.";
            }
        }
        return "Código de producto incorrecto. Ingrese código nuevamente";
    }
}
