package com.alexis.market.web.controller;

import com.alexis.market.domain.Product;
import com.alexis.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    public List<Product> getAll() {
        return productService.getAll();
    }
}
