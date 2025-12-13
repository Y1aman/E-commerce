package com.yaman.ecommerce.controllers;

import com.yaman.ecommerce.models.Product;
import com.yaman.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
    @GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "productForm";
    }
    @PostMapping("/add")
    public String saveProduct(@ModelAttribute Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@ModelAttribute Product product){
        productService.deleteProduct(product.getId());
        return "redirect:/products";
    }
}
