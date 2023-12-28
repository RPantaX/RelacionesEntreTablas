package com.sistema.inventario.sistemainventariospringboot.marca;

import com.sistema.inventario.sistemainventariospringboot.categoria.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "marca")
@AllArgsConstructor
@NoArgsConstructor
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45, nullable = false, unique = true)
    private String nombre;

    @OneToMany
    @JoinColumn(name = "marca_id")
    private List<Categoria> categorias= new ArrayList<>();
    public Marca(String nombre){
        this.nombre=nombre;
    }
}
