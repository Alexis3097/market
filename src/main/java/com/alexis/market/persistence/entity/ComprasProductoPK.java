package com.alexis.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
public class ComprasProductoPK implements Serializable {
    @Column(name = "id_compra")
    private Long idCompra;

    @Column(name = "id_producto")
    private Long id_producto;
}
