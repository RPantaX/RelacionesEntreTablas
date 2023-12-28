package com.sistema.inventario.sistemainventariospringboot.producto;

import com.sistema.inventario.sistemainventariospringboot.categoria.Categoria;
import com.sistema.inventario.sistemainventariospringboot.categoria.CategoriaRepository;
import com.sistema.inventario.sistemainventariospringboot.categoria.CategoriaService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/productos")
    public String listarProductos(Model model){
        model.addAttribute("listaProductos",productoService.listaProductos());
        return "productos";
    }
    @GetMapping("/productos/nuevo")
    public String FormularioDeNuevoProducto(Model model){
        List<Categoria> listaCategorias=categoriaService.listaCategorias();
        model.addAttribute("producto", new Producto());
        model.addAttribute("listaCategorias", listaCategorias);
        return "producto_formulario";
    }
    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto, HttpServletRequest request){
        String[] detallesID=request.getParameterValues("detallesID");
        String[] detallesNombre=request.getParameterValues("detallesNombre");
        String[] detallesValore=request.getParameterValues("detallesValor");

        for (int i=0; i<detallesNombre.length;i++){
            if(detallesID !=null && detallesID.length>0){
                producto.setDetalles(Integer.valueOf(detallesID[i]),detallesNombre[i],detallesValore[i]);
            } else{
                producto.anadirDetalles(detallesNombre[i],detallesValore[i]);
            }
        }

        productoService.guardarProducto(producto);
        return "redirect:/productos";
    }
    @GetMapping("productos/editar/{id}")
    public String FormularioEditarProducto(Model model, @PathVariable("id") Integer id){
        model.addAttribute("producto", productoService.buscarProductoPorID(id));
        List<Categoria> listaCategorias=categoriaService.listaCategorias();
        model.addAttribute("listaCategorias", listaCategorias);
        return "producto_formulario";
    }

    @GetMapping("productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Integer id){
        productoService.eliminarProducto(id);
        return "redirect:/productos";
    }

}
