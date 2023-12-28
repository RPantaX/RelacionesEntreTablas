package com.sistema.inventario.sistemainventariospringboot.categoria;

import com.sistema.inventario.sistemainventariospringboot.marca.Marca;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "categorias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45, nullable = false, unique = true)
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;
    public Categoria(String nombre) {
        this.nombre=nombre;
    }
    @Override
    public String toString(){
        return nombre;
    }

}
