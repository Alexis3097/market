package com.alexis.market.domain.repository;

import com.alexis.market.domain.Product;
import com.alexis.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();

    Optional<List<Product>> getByCategory(Long categoryId);

    Optional<List<Product>> getScarseProducts(Integer quantity);

    Optional<Product> getProduct(Long id);

    Product save(Product product);

    void delete(Long productId);
}
