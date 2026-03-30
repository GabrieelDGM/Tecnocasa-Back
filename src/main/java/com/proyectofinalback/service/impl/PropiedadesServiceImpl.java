package com.proyectofinalback.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proyectofinalback.dto.request.PropiedadRequestDto;
import com.proyectofinalback.dto.response.PropiedadResponseDto;
import com.proyectofinalback.entities.Propiedades;
import com.proyectofinalback.mapper.PropiedadesMapper;
import com.proyectofinalback.repository.PropiedadesRepository;
import com.proyectofinalback.service.PropiedadesService;

@Service
public class PropiedadesServiceImpl implements PropiedadesService {

    private final PropiedadesRepository repo;

    public PropiedadesServiceImpl(PropiedadesRepository repo) {
        this.repo = repo;
    }

    @Override
    public PropiedadResponseDto crearPropiedad(PropiedadRequestDto dto) {
        Propiedades entidad = PropiedadesMapper.toEntity(dto);
        repo.save(entidad);
        return PropiedadesMapper.toDto(entidad);
    }

    @Override
    public List<PropiedadResponseDto> listarPropiedades() {
        return repo.findAll()
                .stream()
                .map(PropiedadesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PropiedadResponseDto obtenerPorId(Long id) {
        Propiedades p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));
        return PropiedadesMapper.toDto(p);
    }

    @Override
    public List<PropiedadResponseDto> buscar(String tipo, String ciudad, Double maxPrecio) {
        return repo.findAll().stream()
                .filter(p -> tipo == null || p.getTipo().name().equalsIgnoreCase(tipo))
                .filter(p -> ciudad == null || p.getCiudad().equalsIgnoreCase(ciudad))
                .filter(p -> maxPrecio == null || p.getPrecio().doubleValue() <= maxPrecio)
                .map(PropiedadesMapper::toDto)
                .collect(Collectors.toList());
    }
}
