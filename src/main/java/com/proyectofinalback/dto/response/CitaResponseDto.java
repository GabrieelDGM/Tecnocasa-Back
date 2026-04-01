package com.proyectofinalback.dto.response;

import lombok.Data;

@Data
public class CitaResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String motivo;
    private Long propiedadId;
    private String propiedadTitulo;
    private String tipoPropiedad; 
    private Long usuarioId;
}
