package com.proyectofinalback.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoResponseDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String usuario;
    private String rol;
    private String tipoGestor; 
}
