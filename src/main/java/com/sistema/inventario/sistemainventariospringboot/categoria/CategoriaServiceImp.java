package com.sistema.inventario.sistemainventariospringboot.categoria;

import com.sistema.inventario.sistemainventariospringboot.producto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriaServiceImp implements CategoriaService{
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Override
    public List<Categoria> listaCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
