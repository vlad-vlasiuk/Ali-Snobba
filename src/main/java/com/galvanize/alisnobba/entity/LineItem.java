package com.galvanize.alisnobba.entity;

public class LineItem {

    private Product product;
    private Integer quan;

    public LineItem(Product product, Integer quan) {
        this.product = product;
        this.quan = quan;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuan() {
        return quan;
    }

    public void setQuan(Integer quan) {
        this.quan = quan;
    }

    public void incProduct() {
        this.quan = this.quan + 1;
    }

    public void decProduct() {
        this.quan = this.quan - 1;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "product=" + product +
                ", quan=" + quan +
                '}';
    }
}
