package com.sistema.inventario.sistemainventariospringboot.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RolServiceImp implements RolService{
    @Autowired
    private RolRepository rolRepository;
    @Override
    public List<Rol> listaRoles() {
        return rolRepository.findAll();
    }
}
