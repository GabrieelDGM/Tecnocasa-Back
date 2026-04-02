package com.proyectofinalback.mapper;

import com.proyectofinalback.dto.request.PropiedadRequestDto;
import com.proyectofinalback.dto.response.PropiedadResponseDto;
import com.proyectofinalback.entities.Propiedades;
import com.proyectofinalback.entities.TipoPropiedad;

public class PropiedadesMapper {

    public static Propiedades toEntity(PropiedadRequestDto dto) {
        return Propiedades.builder()
                .tipo(TipoPropiedad.valueOf(dto.getTipo().toUpperCase()))
                .titulo(dto.getTitulo())
                .descripcion(dto.getDescripcion())
                .precio(dto.getPrecio())
                .detalles(dto.getDetalles())
                .ciudad(dto.getCiudad())
                .ubicacionGoogle(dto.getUbicacionGoogle())
                .build();
    }

    public static PropiedadResponseDto toDto(Propiedades propiedad) {
        PropiedadResponseDto dto = new PropiedadResponseDto();
        dto.setId(propiedad.getId());
        dto.setTipo(propiedad.getTipo().name());
        dto.setTitulo(propiedad.getTitulo());
        dto.setDescripcion(propiedad.getDescripcion());
        dto.setPrecio(propiedad.getPrecio());
        dto.setDetalles(propiedad.getDetalles());
        dto.setCiudad(propiedad.getCiudad());
        dto.setUbicacionGoogle(propiedad.getUbicacionGoogle());
        return dto;
    }

    public static void updateEntity(Propiedades propiedad, PropiedadRequestDto dto) {

        propiedad.setTipo(TipoPropiedad.valueOf(dto.getTipo().toUpperCase()));
        propiedad.setTitulo(dto.getTitulo());
        propiedad.setDescripcion(dto.getDescripcion());
        propiedad.setPrecio(dto.getPrecio());
        propiedad.setDetalles(dto.getDetalles());
        propiedad.setCiudad(dto.getCiudad());
        propiedad.setUbicacionGoogle(dto.getUbicacionGoogle());
    }

}
