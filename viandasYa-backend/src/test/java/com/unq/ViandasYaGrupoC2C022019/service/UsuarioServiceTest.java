package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.ApplicationTests;
import com.unq.ViandasYaGrupoC2C022019.model.Usuario;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioServiceTest extends ApplicationTests {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void obtenerTodos_conUsuariosPersistidos_retornaUsuarios() {
        List<Usuario> listaDeUsuarios = usuarioService.obtenerTodos();
        assertThat(listaDeUsuarios)
                .asList().isNotEmpty()
                .hasSize(3);
    }
}
