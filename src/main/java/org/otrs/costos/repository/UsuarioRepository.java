package org.otrs.costos.repository;

import java.util.List;
import java.util.Optional;

import org.otrs.costos.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * Definición de lo contratado
 * @author José Pascual Gómez Blanco
 * @serial 24/05/2022
 */
@Repository
public class UsuarioRepository {
    @Autowired
    UsuarioCrudRepository usuarioCrudRepository;

    public Optional<Usuario> findByUsername(){
        return null;
        
    }

    /**
     * @apiNote Permite listar todos los Usuario
     * @return Listado de Usuario
     */
    public List<Usuario> getAll() {
        return (List<Usuario>) usuarioCrudRepository.findAll();
    }

    /**
     * @apiNote consultar un usuario
     * @param Id identificador del usuario a consultar
     * @return usuario consultado
     * @throws ResourceNotFoundException
     */
    public Optional<Usuario> getUsuario(int id)  {
        return usuarioCrudRepository.findById(id);
    }    

    /**
     * @apiNote Permite crear un Usuario
     * @param usuario datos para crear el nuevo Usuario
     * @return Usuario creado
     */
    public Usuario saveUsuario(Usuario usuario){
        return usuarioCrudRepository.save(usuario);
    }

    /**
     * @apiNote Eliminar un usuario por objeto
     * @param usuario usuario a eliminar
     */
    public void deleteUsuario(Usuario usuario){
        usuarioCrudRepository.delete(usuario);
    }

    /**
     * @apiNote Permite eliminar un Usuario
     * @param id Indentificador del Usuario e eliminar
     */
    public void deleteContratoById(Integer id){
        usuarioCrudRepository.deleteById(id);
    }

    public void delete(Integer id) {
    }

    public Page<Usuario> getPaginator(Pageable pageable) {
        return (Page<Usuario>) usuarioCrudRepository.findAll(pageable);
    }
}
