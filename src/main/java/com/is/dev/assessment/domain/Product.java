package com.is.dev.assessment.domain;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    @CsvBindByName(column = "title")
    private String title;
    @CsvBindByName(column = "upc")
    private String upc;
    @CsvBindByName(column = "sku")
    private String sku;
    @CsvBindByName(column = "price")
    private BigDecimal price;
    @CsvBindByName(column = "condition")
    private String condition;
    @CsvBindByName(column = "quantity")
    private Integer quantity;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(sku, product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", upc='" + upc + '\'' +
                ", sku='" + sku + '\'' +
                ", price=" + price +
                ", condition='" + condition + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}