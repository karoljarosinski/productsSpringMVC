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

    @GetMapping("/lista")
    public String showProducts(@RequestParam(name = "kategoria", required = false) String category, Model model) {
        Product product = productRepository.findByCategory(category);


        if (product != null) {
            model.addAttribute("name", product.getCategory().getDescription());
            model.addAttribute("products", productRepository.getAll());
            model.addAttribute("price", productRepository.calculatePrice(category));
            return "product";
        } else {
            model.addAttribute("products", productRepository.getAll());
            model.addAttribute("price", productRepository.calculatePrice(category));
            return "lista";
        }
    }
}
