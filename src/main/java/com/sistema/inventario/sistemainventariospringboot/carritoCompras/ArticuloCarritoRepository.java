package com.sistema.inventario.sistemainventariospringboot.carritoCompras;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloCarritoRepository extends JpaRepository<ArticuloCarrito, Integer> {
}
