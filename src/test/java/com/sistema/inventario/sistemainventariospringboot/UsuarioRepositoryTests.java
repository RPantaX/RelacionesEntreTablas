package com.sistema.inventario.sistemainventariospringboot;

import com.sistema.inventario.sistemainventariospringboot.usuario.Rol;
import com.sistema.inventario.sistemainventariospringboot.usuario.Usuario;
import com.sistema.inventario.sistemainventariospringboot.usuario.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UsuarioRepositoryTests {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testCrearRoles(){
        Rol rolAdmin= new Rol("Administrador");
        Rol rolEditor= new Rol("Editor");
        Rol rolVisitante= new Rol("Visitante");

        entityManager.persist(rolAdmin);
        entityManager.persist(rolEditor);
        entityManager.persist(rolVisitante);
    }

    @Test
    public void testCrearNuevoUsuarioConUnRol(){
        Rol rolAdmin= entityManager.find(Rol.class, 1);
        Usuario usuario= new Usuario("Christian90@gmail.com","12345");
        usuario.anadirRol(rolAdmin);
        usuarioRepository.save(usuario);
    }
    @Test
    public void testCrearNuevoUsuarioConDosRoles(){
        Rol rolEditor= entityManager.find(Rol.class,2);
        Rol rolVisitante=  entityManager.find(Rol.class,3);

        Usuario usuario= new Usuario("biaggio202@gmail.com","1232245");
        usuario.anadirRol(rolEditor);
        usuario.anadirRol(rolVisitante);
        usuarioRepository.save(usuario);
    }
    @Test
    public void testAsignarRolAUsuarioExistente() {
        Usuario usuario= usuarioRepository.findById(1).get();
        Rol rolEditor = entityManager.find(Rol.class, 2);
        usuario.anadirRol(rolEditor);
    }
    @Test
    public void testEliminarRolDeUnUsuarioExistente(){
        Usuario usuario= usuarioRepository.findById(1).get();
        Rol rol= new Rol(2);// LE PASAMOS ID DEL ROL A ELIMINAR
        usuario.eliminarRol(rol);
    }
    @Test
    public void testCrearNuevoUsuarioConNuevoRol(){
        Rol rolVendedor= new Rol("Vendedor");
        Usuario usuario= new Usuario("gabrielram22@gmail.com","12345");
        usuario.anadirRol(rolVendedor);
        usuarioRepository.save(usuario);
    }
    @Test
    public void testObtenerUsuario(){
        Usuario usuario= usuarioRepository.findById(1).get();
        entityManager.detach(usuario);/*Al usar detach, se le indica a JPA que la entidad ya no debe ser administrada
        por el EntityManager, y los cambios realizados en la entidad después de detach no
        se sincronizarán con la base de datos.*/
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getRoles());

    }
    @Test
    public void testEliminarUsuario(){
        usuarioRepository.deleteById(2);
    }
}
