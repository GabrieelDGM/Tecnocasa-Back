package com.proyectofinalback.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinalback.dto.request.PropiedadImagenRequestDto;
import com.proyectofinalback.dto.response.PropiedadImagenDto;
import com.proyectofinalback.entities.PropiedadImagen;
import com.proyectofinalback.entities.Propiedades;
import com.proyectofinalback.repository.PropiedadImagenRepository;
import com.proyectofinalback.repository.PropiedadesRepository;
import com.proyectofinalback.service.PropiedadImagenService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PropiedadImagenServiceImpl implements PropiedadImagenService {
    
    private final PropiedadImagenRepository imagenRepo;
    private final PropiedadesRepository propiedadesRepo;


    @Override
    public List<PropiedadImagenDto> listar(Long propiedadId) {
        Propiedades propiedad = propiedadesRepo.findById(propiedadId)
                .orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));

        return propiedad.getImagenes()
                .stream()
                .map(img -> {
                    PropiedadImagenDto dto = new PropiedadImagenDto();
                    dto.setId(img.getId());
                    dto.setUrl(img.getUrl());
                    return dto;
                })
                .toList();
    }

    @Override
    public PropiedadImagenDto agregar(Long propiedadId, PropiedadImagenRequestDto dto) {
        Propiedades propiedad = propiedadesRepo.findById(propiedadId)
                .orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));

        PropiedadImagen imagen = PropiedadImagen.builder()
                .propiedad(propiedad)
                .url(dto.getUrl())
                .build();

        imagenRepo.save(imagen);

        PropiedadImagenDto response = new PropiedadImagenDto();
        response.setId(imagen.getId());
        response.setUrl(imagen.getUrl());

        return response;
    }

    @Override
    public void eliminar(Long imagenId) {
        imagenRepo.deleteById(imagenId);
    }
}
