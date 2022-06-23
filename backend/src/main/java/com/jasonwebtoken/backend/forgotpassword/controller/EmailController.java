package com.jasonwebtoken.backend.forgotpassword.controller;

import com.jasonwebtoken.backend.dto.Mensaje;
import com.jasonwebtoken.backend.forgotpassword.dto.EmailValuesDTO;
import com.jasonwebtoken.backend.forgotpassword.service.EmailService;
import com.jasonwebtoken.backend.security.entity.Usuario;
import com.jasonwebtoken.backend.security.service.UsuarioService;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forgot-password")
public class EmailController {
    
    @Autowired
    EmailService emailService;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Value("${spring.mail.username}")
    private String mailFrom;
    
    private static final String subject = "Cambio de Contraseña";
    
    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValuesDTO dto) {
        Optional<Usuario> usuarioOpt = usuarioService.getByNombreUsuarioOrEmail(dto.getMailTo());
        if(!usuarioOpt.isPresent())
            return new ResponseEntity(new Mensaje("No existe ningún usuario con esas credenciales"), HttpStatus.NOT_FOUND);
        Usuario usuario = usuarioOpt.get();
        dto.setMailFrom(mailFrom);
        dto.setMailTo(usuario.getEmail());
        dto.setSubject(subject);
        dto.setUserName(usuario.getNombreUsuario());
        UUID uuid = UUID.randomUUID();
        String tokenPassword = uuid.toString();
        dto.setForgotPassword(tokenPassword);
        usuario.setForgotPassword(tokenPassword);
        usuarioService.save(usuario);
        emailService.sendEmail(dto);
        return new ResponseEntity(new Mensaje("Te hemos enviado un correo"), HttpStatus.OK);
    }
}
