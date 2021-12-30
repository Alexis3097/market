package com.alexis.market.persistence;

import com.alexis.market.domain.Product;
import com.alexis.market.domain.repository.ProductRepository;
import com.alexis.market.persistence.crud.ProductoCrudRepository;
import com.alexis.market.persistence.entity.Producto;
import com.alexis.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private  ProductoCrudRepository productoCrudRepository;
    @Autowired
    private  ProductMapper productMapper;



    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(Long categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(Integer quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prod -> productMapper.toProducts(prod));
    }

    @Override
    public Optional<Product> getProduct(Long id) {
//        return productoCrudRepository.findById(id).map(prd -> productMapper.toProduct(prd));
        return productoCrudRepository.findById(id).map(productMapper::toProduct);
    }


    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(Long id) {
        productoCrudRepository.deleteById(id);
    }
}
