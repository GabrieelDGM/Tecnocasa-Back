package com.proyectofinalback.dto.request;

import lombok.Data;

@Data
public class UsuarioLoginRequestDto {
    private String usuario;
    private String contrasena;
}
