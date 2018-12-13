package com.galvanize.alisnobba;

import com.galvanize.alisnobba.entity.Cart;
import com.galvanize.alisnobba.entity.LineItem;
import com.galvanize.alisnobba.entity.Product;

import java.util.List;

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
        cart.getItems().clear();
    }

    public void addProduct(Product product) {
        List<LineItem> items = cart.getItems();
        LineItem lineItem = items.stream()
                .filter(e -> e.getProduct().equals(product))
                .findFirst()
                .orElse(null);
        if (lineItem == null) {
            lineItem = new LineItem(product, 0);
            cart.addItem(lineItem);
        }
        lineItem.incProduct();

    }

    public void incProduct(Product product) {
        List<LineItem> items = cart.getItems();
        LineItem lineItem = items.stream()
                .filter(e -> e.getProduct().equals(product))
                .findFirst()
                .orElse(null);
        if (lineItem == null) {
            throw new IllegalArgumentException("product not found");
        }
        lineItem.incProduct();
    }

}
