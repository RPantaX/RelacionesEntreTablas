package com.sistema.inventario.sistemainventariospringboot;

import com.sistema.inventario.sistemainventariospringboot.carritoCompras.ArticuloCarrito;
import com.sistema.inventario.sistemainventariospringboot.carritoCompras.ArticuloCarritoRepository;
import com.sistema.inventario.sistemainventariospringboot.producto.Producto;
import com.sistema.inventario.sistemainventariospringboot.usuario.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ArticuloCarritoTests {
    @Autowired
    private ArticuloCarritoRepository repository;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testNuevoArticulo(){
        Producto producto=entityManager.find(Producto.class,1);
        Usuario usuario= entityManager.find(Usuario.class,1);

        ArticuloCarrito articulo= new ArticuloCarrito(7,producto,usuario);
        repository.save(articulo);
    }
    @Test
    public void testAgregarMultiplesArticulos(){
        Usuario usuario= new Usuario(1);
        Producto producto1= new Producto(1);
        Producto producto2= new Producto(2);
        ArticuloCarrito articulo1= new ArticuloCarrito(3, producto1, usuario);
        ArticuloCarrito articulo2= new ArticuloCarrito(5, producto2, usuario);
        repository.saveAll(List.of(articulo1,articulo2));
    }
    @Test
    public void testListarArticulos(){
        List<ArticuloCarrito> lista= repository.findAll();
        lista.forEach(System.out::println);
    }
    @Test
    public void testActualizarArticulo(){
        ArticuloCarrito articulo= repository.findById(1).get();
        articulo.setCantidad(11);
        articulo.setProducto(new Producto(1));
    }
    @Test
    public void testEliminarArticulo(){
        repository.deleteById(1);
    }
}
