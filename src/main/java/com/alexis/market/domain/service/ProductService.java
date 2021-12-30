package com.alexis.market.domain.service;

import com.alexis.market.domain.Product;
import com.alexis.market.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProducto(Long id) {
        return productRepository.getProduct(id);
    }

    public Optional<List<Product>> getByCategory(Long categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(Integer quantity) {
        return productRepository.getScarseProducts(quantity);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(Long productId) {
        return getProducto(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
