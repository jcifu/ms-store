package com.jcifu.store.shoppingcart.service;

import java.util.Optional;

import com.jcifu.store.shoppingcart.model.Cart;
import com.jcifu.store.shoppingcart.model.Product;

public interface CartService {
    
    Optional<Cart> findCartById(Integer cartId);

//	void addItem(Cart cart,  Product product, Integer quantity);
	
	void addItem(Integer cartId,  Integer productCode, Integer quantity);
	
//    void deleteItem(Cart cart, Product product);
	
	void deleteItem(Integer cartId, Integer productCode);
	
    Cart saveCart(Cart cart);
}
