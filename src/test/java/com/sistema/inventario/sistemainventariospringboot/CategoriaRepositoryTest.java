package com.sistema.inventario.sistemainventariospringboot;

import com.sistema.inventario.sistemainventariospringboot.categoria.Categoria;
import com.sistema.inventario.sistemainventariospringboot.categoria.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class CategoriaRepositoryTest {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Test
    public void testCrearCategoria(){
        Categoria categoriaGuardada=categoriaRepository.save(new Categoria("Electrónicos"));
        assertThat(categoriaGuardada.getId()).isGreaterThan(0);
    }
}
