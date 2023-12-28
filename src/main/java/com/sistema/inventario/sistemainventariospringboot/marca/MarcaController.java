package com.sistema.inventario.sistemainventariospringboot.marca;

import com.sistema.inventario.sistemainventariospringboot.categoria.Categoria;
import com.sistema.inventario.sistemainventariospringboot.categoria.CategoriaRepository;
import com.sistema.inventario.sistemainventariospringboot.categoria.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MarcaController {
    @Autowired
    private MarcaService marcaService;
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("/marcas/nueva")
    public String FormularioCrearNuevaMarca(Model model){
        List<Categoria> listaCategorias=categoriaService.listaCategorias();
        model.addAttribute("listaCategorias", listaCategorias);
        model.addAttribute("marca", new Marca());
        return "marca_formulario";
    }
    @PostMapping("/marcas/guardar")
    public String guardarMarca(Marca marca){
        marcaService.guardarMarca(marca);
        return "redirect:/";
    }
    @GetMapping("/marcas")
    public String listarMarcas(Model model){
        List<Marca> listaMarcas=marcaService.listaMarcas();
        model.addAttribute("listaMarcas",listaMarcas);
        return "marcas";
    }
    @GetMapping("/marcas/editar/{id}")
    public String FormularioEditarNuevaMarca(@PathVariable("id") Integer id, Model model){
        List<Categoria> listaCategorias=categoriaService.listaCategorias();//le pasamos la lista por las marcas
        Marca marca= marcaService.buscarMarcaPorID(id);
        model.addAttribute("marca", marca);
        model.addAttribute("listaCategorias",listaCategorias);
        return "marca_formulario";
    }
}
