package com.sistema.inventario.sistemainventariospringboot.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("/categorias")
    public String listarCategorias(Model model){
        List<Categoria> listaCategorias= categoriaService.listaCategorias();
        model.addAttribute("listaCategorias", listaCategorias);
        return "categorias";
    }
    @GetMapping("/categorias/nuevo")
    public String formularioNuevaCategoria(Model model){
        model.addAttribute("categoria", new Categoria());
        return "categoria_formulario";
    }
    @PostMapping("/categorias/guardar")
    public String guardarCategoria(Categoria categoria){
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categorias";
    }
}
