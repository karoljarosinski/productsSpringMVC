package com.kj.productsSpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {

    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/list")
    public String showProducts2(@RequestParam(name = "kategoria", defaultValue = "") String category, Model model) {
        model.addAttribute("name", category);
        model.addAttribute("products", productRepository.getAll());
        model.addAttribute("price", productRepository.calculatePrice(category));
        return "list";
    }
}
