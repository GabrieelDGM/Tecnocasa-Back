package com.proyectofinalback.dto.response;

import java.math.BigDecimal;
import java.util.List;

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
public class PropiedadResponseDto {
    private Long id;
    private String tipo;
    private String titulo;
    private String descripcion;
    private BigDecimal precio;
    private String detalles;
    private String ciudad;
    private String ubicacionGoogle;
    private List<String> imagenes;


}
