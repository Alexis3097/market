package com.alexis.market.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "compras")
@Setter
@Getter
@NoArgsConstructor
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra", unique = true)
    private Long idCompra;

    @Column(name = "id_cliente")
    private String idCliente;

    private LocalDate fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;
    

    @OneToMany(mappedBy = "producto")
    private List<ComprasProducto> productos;
}
    