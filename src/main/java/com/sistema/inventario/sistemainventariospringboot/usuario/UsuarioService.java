package com.sistema.inventario.sistemainventariospringboot.usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> listaUsuarios();
    Usuario guardarUsuario(Usuario usuario);
    Usuario buscarUsuarioPorID(Integer id);
    void eliminarUsuario(Integer id);
}
