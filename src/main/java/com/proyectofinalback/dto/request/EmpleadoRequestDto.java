package com.proyectofinalback.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoRequestDto {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String contrasena;
    private String usuario;
    private String rol;
}
