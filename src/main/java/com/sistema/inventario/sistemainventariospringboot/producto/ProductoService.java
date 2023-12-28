package com.sistema.inventario.sistemainventariospringboot.producto;

import com.sistema.inventario.sistemainventariospringboot.categoria.Categoria;

import java.util.List;

public interface ProductoService {
    List<Producto> listaProductos();
    Producto guardarProducto(Producto producto);
    Producto buscarProductoPorID(Integer id);
    void eliminarProducto(Integer id);
}
