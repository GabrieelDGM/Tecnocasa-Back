package com.proyectofinalback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinalback.dto.request.PropiedadImagenRequestDto;
import com.proyectofinalback.dto.response.PropiedadImagenDto;
@Service
public interface PropiedadImagenService {

    List<PropiedadImagenDto> listar(Long propiedadId);

    PropiedadImagenDto agregar(Long propiedadId, PropiedadImagenRequestDto dto);

    void eliminar(Long imagenId);
}
