package com.alexis.market.persistence;

import com.alexis.market.domain.Product;
import com.alexis.market.domain.repository.ProductRepository;
import com.alexis.market.persistence.crud.ProductoCrudRepository;
import com.alexis.market.persistence.entity.Producto;
import com.alexis.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper productMapper;

    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(Long categoryId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Product>> getScarseProducts(Integer quantity) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    public List<Producto> getByIdCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(Integer cantidadStock, Boolean estado) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, estado);
    }

    public Optional<Producto> getProducto(Long id) {
        return productoCrudRepository.findById(id);
    }

    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public void delete(Long id) {
        productoCrudRepository.deleteById(id);
    }
}
