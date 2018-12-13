package com.galvanize.alisnobba.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<LineItem> items = new ArrayList<>();

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }

    public void addItem(LineItem item) {
        items.add(item);
    }


    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }
}
