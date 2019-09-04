package com.unq.ViandasYaGrupoC2C022019.webservice;

import com.unq.ViandasYaGrupoC2C022019.model.Usuario;
import com.unq.ViandasYaGrupoC2C022019.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UsuarioRestController {

    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/usuario")
    public List<Usuario> listar(){
        List<Usuario> usuarios = usuarioService.obtenerTodos();
        return usuarios;
    }
    
    @DeleteMapping("/usuario")
    public void borrar(Long id) {
        usuarioService.borrar(id);
    }

    @PostMapping("/usuario")
    public Usuario guardar(@RequestBody Usuario usuario) {

        usuarioService.guardar(usuario);
        return usuario;
    }
}