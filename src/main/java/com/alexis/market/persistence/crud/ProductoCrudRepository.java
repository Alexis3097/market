package com.alexis.market.persistence.crud;

import com.alexis.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {
    List<Producto> findByIdCategoriaOrderByNombreAsc(Long idCategoria);
    Optional <List<Producto>> findByCantidadStockLessThanAndEstado(Integer cantidadStock, Boolean estado);
}
