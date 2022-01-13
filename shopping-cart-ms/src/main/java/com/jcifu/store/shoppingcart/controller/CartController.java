package com.jcifu.store.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import com.jcifu.store.shoppingcart.model.Cart;
import com.jcifu.store.shoppingcart.model.Product;
import com.jcifu.store.shoppingcart.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    
    @Autowired
    private CartService shoppingService;

    //get cart
    @GetMapping(value = "/cart/{cartId}")
    public Optional<Cart> getCart(@PathVariable Integer cartId){
        return shoppingService.findCartById(cartId);
    }

    //add item
    @PostMapping(value = "/cart/{cartId}/addItem/{productCode}/quantity/{quantity}")
    public void addCartItem(@PathVariable Integer cartId, @PathVariable Integer productCode, @PathVariable Integer quantity){
        
    	shoppingService.addItem(cartId, productCode, quantity);
    	
    	
		/*
		 * Optional<Cart> actualCart = shoppingService.findCartById(cartId);
		 * 
		 * List<Product> items = actualCart.get().getProducts();
		 */
    	
    	/*
		 * Optional<Cart> actualCart = shoppingService.findCartById(cart.getCartId());
		 * 
		 * List<Product> items = actualCart.get().getProducts();
		 * 
		 * items.forEach( cartItem ->{
		 * 
		 * cartItem.setProductCode(product.getProductCode());
		 * cartItem.setProductName(product.getProductName());
		 * cartItem.setPrice(product.getPrice()); cartItem.setQuantity(quantity);
		 * 
		 * });
		 */
        
    }

    //delete item
//    @DeleteMapping(value = "/cart/delete/{productCode}")
//    public void deleteCartItem(@PathVariable Integer productCode, Cart cart){
//        
//        Optional <Cart> actualCart = shoppingService.findCartById(cart.getCartId());
//        shoppingService.deleteItem(productCode);
//    }
//    
//    @PostMapping(value = "/cart/save/{cartId}")
//    public Cart saveCart(Cart cart) {
//    	shoppingService.saveCart(cartId);
//    }

    

}
