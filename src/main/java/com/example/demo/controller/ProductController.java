package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping(path="/demo")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewProduct (@RequestParam String productName, @RequestParam String skuId) {
        Product product = new Product();
        product.setProductName(productName);
        product.setSkuId(skuId);
        productRepository.save(product);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
