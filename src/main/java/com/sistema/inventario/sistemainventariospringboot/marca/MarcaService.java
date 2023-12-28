package com.sistema.inventario.sistemainventariospringboot.marca;


import java.util.List;

public interface MarcaService {
    List<Marca> listaMarcas();
    Marca guardarMarca(Marca marca);
    Marca buscarMarcaPorID(Integer id);
}
