package org.otrs.costos.repository;

import org.otrs.costos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioCrudRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsername(String username);
}
