package com.proyectofinalback.service;

import java.util.List;

import com.proyectofinalback.dto.request.CitaRequestDto;
import com.proyectofinalback.dto.response.CitaResponseDto;
import com.proyectofinalback.entities.Cita;

public interface CitaService {

    CitaResponseDto crear(CitaRequestDto dto);

    List<CitaResponseDto> listarPorGestor(Long empleadoId);

    CitaResponseDto obtenerPorId(Long id);

}
