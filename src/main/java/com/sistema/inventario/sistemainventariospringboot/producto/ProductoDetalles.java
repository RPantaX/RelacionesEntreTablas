package com.sistema.inventario.sistemainventariospringboot.producto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "producto_detalles")
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDetalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45, nullable = false)
    private String nombre;
    @Column(length = 45, nullable = false)
    private String valor;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto; //este producto es el que está en Productos.java
    public ProductoDetalles(String nombre, String valor, Producto producto){
        this.nombre=nombre;
        this.valor=valor;
        this.producto=producto;
    }
    @Override
    public String toString(){
        return nombre+" - "+valor;
    }
}
