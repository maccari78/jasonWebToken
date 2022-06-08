package com.jasonwebtoken.backend.security.dto;

public class JwtDto {

    public JwtDto() {
    }
    
    private String token;
    
    public JwtDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

        
}
