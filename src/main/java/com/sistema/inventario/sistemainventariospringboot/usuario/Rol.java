package com.sistema.inventario.sistemainventariospringboot.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "rol")
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 25, nullable = false, unique = true)
    private String nombre;
    public Rol(String nombre){
        this.nombre=nombre;
    }
    public Rol(Integer id){
        this.id=id;
    }
    @Override
    public String toString() {
        return nombre;
    }
}
