package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.model.Usuario;
import java.util.List;

public interface UsuarioService {
    
    public List<Usuario> obtenerTodos();
    
    public void borrar(long id);

    public Usuario obtener(long id);

    public void guardar(Usuario UsuarioNuevo);
}
