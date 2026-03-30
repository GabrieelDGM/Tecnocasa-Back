package com.proyectofinalback.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PropiedadRequestDto {

    private String tipo;
    private String titulo;
    private String descripcion;
    private BigDecimal precio;
    private String detalles;
    private String ciudad;
    private String ubicacionGoogle;
}
