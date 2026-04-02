package com.proyectofinalback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinalback.dto.request.PropiedadRequestDto;
import com.proyectofinalback.dto.response.PropiedadResponseDto;

@Service
public interface PropiedadesService {

    PropiedadResponseDto crearPropiedad(PropiedadRequestDto dto);

    List<PropiedadResponseDto> listarPropiedades();

    PropiedadResponseDto obtenerPorId(Long id);

    PropiedadResponseDto actualizarPropiedad(Long id, PropiedadRequestDto dto);

    List<PropiedadResponseDto> buscar(String tipo, String ciudad, Double maxPrecio);
}
