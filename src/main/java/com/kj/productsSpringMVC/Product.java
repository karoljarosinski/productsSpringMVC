package com.kj.productsSpringMVC;

public class Product {
    private String name;
    private int price;
    private Category category;

    public Product(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
