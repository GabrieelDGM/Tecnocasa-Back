package com.proyectofinalback.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyectofinalback.dto.request.CitaRequestDto;
import com.proyectofinalback.dto.response.CitaResponseDto;
import com.proyectofinalback.entities.Cita;
import com.proyectofinalback.entities.Propiedades;
import com.proyectofinalback.mapper.CitaMapper;
import com.proyectofinalback.repository.PropiedadesRepository;
import com.proyectofinalback.service.CitaService;

import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/citas")   
@RequiredArgsConstructor
public class CitaController {

    private final CitaService citaService;

    @PostMapping
    public ResponseEntity<CitaResponseDto> crearCita(@RequestBody CitaRequestDto dto) {
        return ResponseEntity.ok(citaService.crear(dto));
    }

    @GetMapping("/gestor/{empleadoId}")
    public ResponseEntity<List<CitaResponseDto>> listarPorGestor(@PathVariable Long empleadoId) {
        return ResponseEntity.ok(citaService.listarPorGestor(empleadoId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.obtenerPorId(id));
    }
}