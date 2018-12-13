package com.galvanize.alisnobba;

import com.galvanize.alisnobba.entity.Cart;
import com.galvanize.alisnobba.entity.LineItem;
import com.galvanize.alisnobba.entity.Product;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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

    @Test(expected = IllegalArgumentException.class)
    public void incWrongProductTest() {
        Cart cart = new Cart();
        Product notFindProduct = new Product.ProductBuilder()
                .id(3L)
                .name("notFindProduct")
                .price(new BigDecimal(0.50))
                .build();

        Product watch = new Product.ProductBuilder()
                .id(1L)
                .name("watch SuperWatch")
                .price(new BigDecimal(5000.50))
                .build();
        LineItem lineItem1 = new LineItem(watch, 1);
        Product someProduct = new Product.ProductBuilder()
                .id(2L)
                .name("someProduct")
                .price(new BigDecimal(1.50))
                .build();
        LineItem lineItem2 = new LineItem(someProduct, 1);
        cart.setItems(new ArrayList<>(Arrays.asList(lineItem1, lineItem2)));

        service.setCart(cart);

        service.incProduct(notFindProduct);


    }

    @Test
    public void incProductTest() {
        Cart cart = new Cart();
        Product watch = new Product.ProductBuilder()
                .id(1L)
                .name("watch SuperWatch")
                .price(new BigDecimal(5000.50))
                .build();
        LineItem lineItem1 = new LineItem(watch, 1);
        Product someProduct = new Product.ProductBuilder()
                .id(2L)
                .name("someProduct")
                .price(new BigDecimal(1.50))
                .build();
        LineItem lineItem2 = new LineItem(someProduct, 1);
        cart.setItems(new ArrayList<>(Arrays.asList(lineItem1, lineItem2)));

        service.setCart(cart);

        service.incProduct(watch);

        List<LineItem> items = service.getCart().getItems();

        List<LineItem> collect = items.stream().filter(e -> e.getProduct().equals(watch)).collect(Collectors.toList());

        assertThat(collect.size(), is(1));
        assertThat(collect.get(0).getProduct(), is(watch));
        assertThat(collect.get(0).getQuan(), is(2));

    }

}