package com.sistema.inventario.sistemainventariospringboot.usuario;

import com.sistema.inventario.sistemainventariospringboot.usuario.Usuario;
import com.sistema.inventario.sistemainventariospringboot.usuario.UsuarioRepository;
import com.sistema.inventario.sistemainventariospringboot.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> listaUsuarios() {
        return usuarioRepository.findAll();
    }
    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @Override
    public Usuario buscarUsuarioPorID(Integer id) {
        return usuarioRepository.findById(id).get();
    }
    @Override
    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
