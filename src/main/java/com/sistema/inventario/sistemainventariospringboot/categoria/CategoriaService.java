package com.sistema.inventario.sistemainventariospringboot.categoria;

import com.sistema.inventario.sistemainventariospringboot.producto.Producto;

import java.util.List;

public interface CategoriaService {
    List<Categoria> listaCategorias();
    Categoria guardarCategoria(Categoria categoria);
}
