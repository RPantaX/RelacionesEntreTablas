package com.sistema.inventario.sistemainventariospringboot.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45, nullable = false, unique = true)
    private String email;
    @Column(length = 10, nullable = false)
    private String password;

    @ManyToMany//(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER) //PERSIST:lo que hacemos a un objeto, tambien se ejecute a sus hijos/ej: si queremos eliminar, persistir,etc.
    //EAGER: Ansiosa, que siempre que llamamos al objeto lo llame de inmediato
    @JoinTable(name = "usuario_rol",joinColumns = @JoinColumn(name = "usuario_id"),//se refiere a la tabla de usuario
    inverseJoinColumns = @JoinColumn(name = "rol_id")) //se refiere a la tabla de roles
    private Set<Rol> roles = new HashSet<>();
    public Usuario(String email, String password){
        this.email=email;
        this.password=password;
    }
    public Usuario(Integer id){
        this.id= id;
    }
    public void anadirRol(Rol rol){
        this.roles.add(rol);
    }
    public void eliminarRol(Rol rol){
        this.roles.remove(rol);
    }
    @Override
    public String toString() {
        return this.email;
    }
}
