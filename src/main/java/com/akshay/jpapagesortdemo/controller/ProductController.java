package com.akshay.jpapagesortdemo.controller;

import com.akshay.jpapagesortdemo.model.Product;
import com.akshay.jpapagesortdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public PageResponse<Product> getProducts(
            @RequestParam Integer pageIndex,
            @RequestParam Integer pageSize,
            @RequestParam  String sortBy
    ) {
        Page<Product> page = productService.getProductsByPage(pageIndex, pageSize, sortBy);
        return new PageResponse<>(page);
    }

    @PostMapping("/")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
