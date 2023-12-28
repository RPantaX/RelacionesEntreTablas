package com.sistema.inventario.sistemainventariospringboot.producto;

import com.sistema.inventario.sistemainventariospringboot.categoria.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 128, nullable = false, unique = true)
    private String nombre;
    private float precio;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL) //este producto esta en ProductosDetalles. Cascade en hibernate significa que cualquier operacion que le hagamos al producto también será para todos los objetos relacionados.
    private List<ProductoDetalles> detalles= new ArrayList<>();
    public Producto(String nombre, float precio, Categoria categoria){
        this.nombre=nombre;
        this.precio=precio;
        this.categoria=categoria;
    }
    public Producto(String nombre){
        this.nombre=nombre;
    }
    public Producto(Integer id){
        this.id=id;
    }
    public void setDetalles(Integer id, String detallesNombre, String detallesValores) {
        this.detalles.add( new ProductoDetalles(id, detallesNombre,detallesValores, this));
    }
    public void anadirDetalles(String nombre, String valor){
        this.detalles.add(new ProductoDetalles(nombre,valor,this)); //this: hace referencia al producto que está entre paréntesis de arriba
    }


}

