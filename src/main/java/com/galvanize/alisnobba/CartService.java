package com.galvanize.alisnobba;

import com.galvanize.alisnobba.entity.Cart;
import com.galvanize.alisnobba.entity.Product;

public class CartService {

    private Cart cart;

    public CartService() {}

    public CartService(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void clearCart() {

    }

    public void addProduct(Product product) {


    }

}
