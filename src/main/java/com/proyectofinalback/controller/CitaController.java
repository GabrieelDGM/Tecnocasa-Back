package com.proyectofinalback.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyectofinalback.dto.request.CitaRequestDto;
import com.proyectofinalback.dto.response.CitaResponseDto;
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

    @PutMapping("/{id}/confirmar")
    public ResponseEntity<CitaResponseDto> confirmar(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.confirmar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        citaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
