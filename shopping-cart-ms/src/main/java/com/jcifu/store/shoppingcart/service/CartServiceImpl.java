package com.jcifu.store.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import com.jcifu.store.shoppingcart.model.Cart;
import com.jcifu.store.shoppingcart.model.Product;
import com.jcifu.store.shoppingcart.repository.CartRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    
    @Autowired
    private CartRepo shoppingCart;

	@Autowired
	private Product product;
	 
    
    @Override
    public Optional<Cart> findCartById(Integer cartId) {
    	/*
		 * if(shoppingCart.existsById(cartId)){ Cart cart =
		 * shoppingCart.getById(cartId); return cart; }else { Cart cart = new Cart();
		 * cart.setCartId(cartId); return cart; }
		 */
    	
    	Optional<Cart> actualCart = shoppingCart.findById(cartId);
    	return actualCart;
		        
    } 

    @Override
	//public void addItem(Cart cart, Product product, Integer quantity) {
	public void addItem(Integer cartId, Integer productCode, Integer quantity) {
    		
    	Optional<Cart> actualCart = shoppingCart.findById(cartId);
    	
    	List<Product> items = actualCart.get().getProducts(); // está bien?? debe ir con stream()? 
    	
    	items.forEach( 
    			item -> { 
    				item.setProductCode(productCode);
    				item.setProductName(product.getProductName());
    				item.setQuantity(quantity);
    				item.setPrice(product.getPrice()); 
    				} 
    			);
		  
    	actualCart.get().setTotalSale(product.getPrice() * quantity);
    	
		/*
		 * Optional<Cart> actualCart = shoppingCart.findById(cart.getCartId());
		 * 
		 * List<Product> items = actualCart.get().getProducts(); // está bien?? debe ir
		 * con stream()?
		 * 
		 * items.forEach( item -> { item.setProductCode(product.getProductCode());
		 * item.setProductName(product.getProductName()); item.setQuantity(quantity);
		 * item.setPrice(product.getPrice()); } );
		 * 
		 * actualCart.get().setTotalSale(product.getPrice() * quantity);
		 * shoppingCart.save(userCart); // debe guardarse en el servicio?
		 */        
            
    }

    @Override
//    public void deleteItem(Cart cart, Product product) {
    public void deleteItem(Integer cartId, Integer productCode) {    
		
    	Optional<Cart> actualCart = shoppingCart.findById(cartId);
    	
    	List<Product> items = actualCart.get().getProducts();
    	
    	if (productCode != null && cartId != null) {
    		
    		//toDelete
    	}
    				
    	/*
		 * Optional<Cart> actualCart = shoppingCart.findById(cart.getCartId());
		 * 
		 * List<Product> items = actualCart.get().getProducts();
		 * 
		 * if (product.getProductCode() != null &&
		 * shoppingCart.existsById(cart.getCartId())) {
		 * items.remove(product.getProductCode()); // revisar }
		 */
    }

    @Override
    public Cart saveCart(Cart cart) {
        return shoppingCart.save(cart);
    }
}
