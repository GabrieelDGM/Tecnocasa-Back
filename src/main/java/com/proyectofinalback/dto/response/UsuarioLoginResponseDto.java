package com.proyectofinalback.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class UsuarioLoginResponseDto {
    private Long id;
    private String usuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String token;
    private List<String> roles;
}
