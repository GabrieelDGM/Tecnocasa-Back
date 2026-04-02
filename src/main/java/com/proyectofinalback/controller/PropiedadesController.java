package com.proyectofinalback.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinalback.dto.request.PropiedadRequestDto;
import com.proyectofinalback.dto.response.PropiedadResponseDto;
import com.proyectofinalback.service.PropiedadesService;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/propiedades")
public class PropiedadesController {

    private final PropiedadesService service;

    @PostMapping
    public PropiedadResponseDto crear(@RequestBody PropiedadRequestDto dto) {
        return service.crearPropiedad(dto);
    }

    @GetMapping
    public List<PropiedadResponseDto> listar() {
        return service.listarPropiedades();
    }

    @GetMapping("/{id}")
    public PropiedadResponseDto obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @GetMapping("/buscar")
    public List<PropiedadResponseDto> buscar(
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) String ciudad,
            @RequestParam(required = false) Double maxPrecio) {

        return service.buscar(tipo, ciudad, maxPrecio);
    }

    @PutMapping("/{id}")
    public PropiedadResponseDto actualizar(
            @PathVariable Long id,
            @RequestBody PropiedadRequestDto dto) {

        return service.actualizarPropiedad(id, dto);
    }
}
