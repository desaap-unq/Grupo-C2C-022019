package com.unq.ViandasYaGrupoC2C022019.service.impl;

import com.unq.ViandasYaGrupoC2C022019.model.Usuario;
import com.unq.ViandasYaGrupoC2C022019.persistence.UsuarioRepository;
import com.unq.ViandasYaGrupoC2C022019.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    @Override
    public List<Usuario> obtenerTodos() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public void borrar(long id) {
        this.usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario obtener(long id) {
        return this.usuarioRepository.findById(id).orElse(new Usuario());
    }

    @Override
    public void guardar(Usuario UsuarioNuevo) {
    }
    
}
