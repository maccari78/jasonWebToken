package com.jasonwebtoken.backend.security.repository;

import com.jasonwebtoken.backend.security.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    Optional<Usuario> findByNombreUsuarioOrEmail(String nombreUsuario, String email);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
}
