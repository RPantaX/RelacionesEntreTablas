package com.sistema.inventario.sistemainventariospringboot.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @GetMapping("/usuarios")
    public String listarUsuarios(Model model){
        List<Usuario> listaUsuarios= usuarioService.listaUsuarios();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return"usuarios";
    }
    @GetMapping("/usuarios/nuevo")
    public String formularioDeRegistroDeUsuario(Model model){
        List<Rol> listaRoles= rolService.listaRoles();
        model.addAttribute("listaRoles", listaRoles);
        model.addAttribute("usuario", new Usuario());
        return"usuario_formulario";
    }
    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }
    @GetMapping("usuarios/editar/{id}")
    public String FormularioEditarUsuario(Model model, @PathVariable("id") Integer id){
        Usuario usuario= usuarioService.buscarUsuarioPorID(id);
        model.addAttribute("usuario", usuario);
        model.addAttribute("listaRoles", rolService.listaRoles());
        return "usuario_formulario";
    }
    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Integer id){
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

}
