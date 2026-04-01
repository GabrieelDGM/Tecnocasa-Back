package com.proyectofinalback.dto.request;

import lombok.Data;

@Data
public class CitaRequestDto {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String motivo;
    private Long propiedadId;
    private Long usuarioId;

}
