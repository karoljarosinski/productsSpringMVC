package com.kj.productsSpringMVC;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("Masło", 5, Category.FOOD));
        products.add(new Product("Mleko", 7, Category.FOOD));
        products.add(new Product("Mop", 9, Category.HOME));
        products.add(new Product("Firanki", 15, Category.HOME));
        products.add(new Product("Krzesło", 30, Category.HOME));
        products.add(new Product("Plecak", 50, Category.OTHER));
        products.add(new Product("Płyn do spryskiwaczy", 4, Category.OTHER));
        products.add(new Product("Srubokret", 17, Category.OTHER));
    }

    public List<Product> getAll() {
        return products;
    }

    public int calculatePrice(String category) {
        int sum = 0;
        if (category.equals("")) {
            for (Product product : products) {
                sum += product.getPrice();
            }
        } else {
            for (Product product : products) {
                if (product.getCategory().getDescription().equals(category)) {
                    sum += product.getPrice();
                }
            }
        }
        return sum;
    }

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> findByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().getDescription().equals(category)) {
                result.add(product);
            }
        }
        return result;
    }
}
