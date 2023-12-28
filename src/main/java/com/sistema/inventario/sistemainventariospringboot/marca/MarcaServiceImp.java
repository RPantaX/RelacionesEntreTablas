package com.sistema.inventario.sistemainventariospringboot.marca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarcaServiceImp implements MarcaService{
    @Autowired
    private MarcaRepository marcaRepository;
    @Override
    public List<Marca> listaMarcas() {
        return marcaRepository.findAll();
    }

    @Override
    public Marca guardarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Marca buscarMarcaPorID(Integer id) {
        return marcaRepository.findById(id).get();
    }
}
