package com.jasonwebtoken.backend.security.service;

import com.jasonwebtoken.backend.security.entity.Usuario;
import com.jasonwebtoken.backend.security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UsuarioService usuarioService;
    
    @Override
    public UserDetails loadUserByUsername(String nombreOrEmail) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuarioOrEmail(nombreOrEmail).get();
        return UsuarioPrincipal.build(usuario);
    }
    
}
