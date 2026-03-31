package com.proyectofinalback.mapper;

import com.proyectofinalback.dto.response.PropiedadImagenDto;
import com.proyectofinalback.entities.PropiedadImagen;

public class PropiedadImagenMapper {
    public static PropiedadImagenDto toDto(PropiedadImagen img) {
        PropiedadImagenDto dto = new PropiedadImagenDto();
        dto.setId(img.getId());
        dto.setUrl(img.getUrl());
        return dto;
    }
}
