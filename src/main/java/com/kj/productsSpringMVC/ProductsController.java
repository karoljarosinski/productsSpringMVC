package com.kj.productsSpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {

    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/list")
    public String showProducts(@RequestParam(name = "kategoria", defaultValue = "") String category, Model model) {
        model.addAttribute("category", category);
        model.addAttribute("products", productRepository.getAll());
        model.addAttribute("price", productRepository.calculatePrice(category));
        return "list";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam int price,
                             @RequestParam Category category) {
        Product product = new Product(name, price, category);
        productRepository.add(product);
        return "redirect:/";
    }
}
