package com.sistema.inventario.sistemainventariospringboot.carritoCompras;

import com.sistema.inventario.sistemainventariospringboot.producto.Producto;
import com.sistema.inventario.sistemainventariospringboot.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "articulo_carrito")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ArticuloCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    public ArticuloCarrito(int cantidad, Producto producto, Usuario usuario){
        this.cantidad=cantidad;
        this.producto=producto;
        this.usuario=usuario;
    }

}
