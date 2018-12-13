package com.galvanize.alisnobba.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CartTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addProduct() {
    }

    @Test
    public void addItem() {

        Product watch = new Product.ProductBuilder()
                .id(1L)
                .name("watch SuperWatch")
                .price(new BigDecimal(5000.50))
                .build();
        Cart cart = new Cart();
        cart.addProduct(watch);

        List<LineItem> items = cart.getItems();

        List<LineItem> collect = items.stream().filter(e -> e.getProduct().equals(watch)).collect(Collectors.toList());

        assertThat(collect.size(), is(1));
        assertThat(collect.get(0).getProduct(), is(watch));
        assertThat(collect.get(0).getQuan(), is(1));
    }

    @Test
    public void clearCartTest() {

        Cart cart = new Cart();
        cart.clearCart();
        assertThat("expected that size cart is 0", cart.getItems().size(), is(0));

    }
}