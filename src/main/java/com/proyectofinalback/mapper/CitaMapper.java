package com.proyectofinalback.mapper;

import com.proyectofinalback.dto.request.CitaRequestDto;
import com.proyectofinalback.dto.response.CitaResponseDto;
import com.proyectofinalback.entities.Cita;
import com.proyectofinalback.entities.Propiedades;

public class CitaMapper {

    public static Cita toEntity(CitaRequestDto dto, Propiedades propiedad) {
        return Cita.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .motivo(dto.getMotivo())
                .propiedad(propiedad)
                .build();
    }

    public static CitaResponseDto toDto(Cita cita) {
        CitaResponseDto dto = new CitaResponseDto();
        dto.setId(cita.getId());
        dto.setNombre(cita.getNombre());
        dto.setApellido(cita.getApellido());
        dto.setEmail(cita.getEmail());
        dto.setTelefono(cita.getTelefono());
        dto.setMotivo(cita.getMotivo());
        dto.setPropiedadId(cita.getPropiedad().getId());
        dto.setPropiedadTitulo(cita.getPropiedad().getTitulo());
        dto.setTipoPropiedad(cita.getPropiedad().getTipo().name());
        return dto;
    }
}
