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

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("product", new Product());
        return "index";
    }

    @GetMapping("/list")
    public String showProducts(@RequestParam(name = "kategoria", defaultValue = "") String category, Model model) {
        model.addAttribute("category", category);
        if (category.equals("")) {
            model.addAttribute("products", productRepository.getAll());
        } else {
            model.addAttribute("products", productRepository.findByCategory(category));
        }
        model.addAttribute("price", productRepository.calculatePrice(category));
        return "list";
    }

    @PostMapping("/add")
    public String addProduct(Product product) {
        productRepository.add(product);
        return "redirect:/";
    }
}
