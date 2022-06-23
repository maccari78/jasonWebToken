package com.jasonwebtoken.backend.forgotpassword.controller;

import com.jasonwebtoken.backend.dto.Mensaje;
import com.jasonwebtoken.backend.forgotpassword.dto.EmailValuesDTO;
import com.jasonwebtoken.backend.forgotpassword.service.EmailService;
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
    
    @Value("${spring.mail.username}")
    private String mailFrom;
    
    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValuesDTO dto){
        dto.setMailFrom(mailFrom);
        dto.setSubject("Cambio de contraseña");
        dto.setUserName("Danilo");
        UUID uuid=UUID.randomUUID();
        String forgotPassword=uuid.toString();
        dto.setForgotPassword(forgotPassword);
        emailService.sendEmail(dto);
        return new ResponseEntity(new Mensaje("Te hemos enviado un correo"), HttpStatus.OK);
    } 
}
