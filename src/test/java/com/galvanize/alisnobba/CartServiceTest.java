package com.galvanize.alisnobba;

import com.galvanize.alisnobba.CartService;
import com.galvanize.alisnobba.entity.Cart;
import com.galvanize.alisnobba.entity.LineItem;
import com.galvanize.alisnobba.entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CartServiceTest {

    CartService service;

    @Before
    public void setUp() throws Exception {

        service = new CartService();

    }

    @Test
    public void addProductTest() {

        Cart cart = new Cart();

        service.setCart(cart);

        Product watch = new Product.ProductBuilder()
                .id(1L)
                .name("watch SuperWatch")
                .price(new BigDecimal(5000.50))
                .build();
        service.addProduct(watch);

        List<LineItem> items = service.getCart().getItems();

        List<LineItem> collect = items.stream().filter(e -> e.getProduct().equals(watch)).collect(Collectors.toList());

        assertThat(collect.size(), is(1));
        assertThat(collect.get(0).getProduct(), is(watch));
        assertThat(collect.get(0).getQuan(), is(1));
    }

    @Test
    public void clearCartTest() {

        service.setCart(new Cart());
        service.clearCart();
        assertThat("expected that size cart is 0", service.getCart().getItems().size(), is(0));

    }
}