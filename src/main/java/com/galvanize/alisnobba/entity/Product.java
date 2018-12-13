package com.galvanize.alisnobba.entity;

import java.math.BigDecimal;

public class Product {

    Long id;
    String name;
    BigDecimal price;

    private Product(ProductBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
    }

    public static class ProductBuilder {
        private Long id;
        private String name;
        private BigDecimal price;

        public ProductBuilder() {

        }

        public ProductBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }
        public ProductBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!id.equals(product.id)) return false;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
