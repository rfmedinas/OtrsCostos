package org.otrs.costos.service;

import java.util.List;
import java.util.Optional;

import org.otrs.costos.model.Usuario;
import org.otrs.costos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Servicio que expone los metodos del CRUD para un usuario
 * @author José Pascual Gómez Blanco
 * @serial 24/05/2022
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return usuarioRepository.getAll();
    }

    public Optional<Usuario> getUsuario(Integer usuarioId) {
        return usuarioRepository.getUsuario(usuarioId);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.saveUsuario(usuario);
    }

    public boolean delete(Integer usuarioId) {
        return getUsuario(usuarioId).map(usuario -> {
            usuarioRepository.deleteContratoById(usuarioId);
            return true;
        }).orElse(false);
    }

    public boolean delete(Usuario usuario){
        return getUsuario(usuario.getId()).map(usuario1 -> {
            usuarioRepository.delete(usuario1.getId());
            return true;
        }).orElse(false);
    }

    public Page<Usuario> getPaginator(Pageable pageable) {
        return usuarioRepository.getPaginator(pageable);
    }

}

