package com.proyectofinalback.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinalback.dto.request.PropiedadImagenRequestDto;
import com.proyectofinalback.dto.response.PropiedadImagenDto;
import com.proyectofinalback.service.PropiedadImagenService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/propiedades/{propiedadId}/imagenes")
@RequiredArgsConstructor
public class PropiedadImagenController {
    private final PropiedadImagenService imagenService;

    @GetMapping
    public List<PropiedadImagenDto> listar(@PathVariable Long propiedadId) {
        return imagenService.listar(propiedadId);
    }

    @PostMapping
    public PropiedadImagenDto agregar(
            @PathVariable Long propiedadId,
            @RequestBody PropiedadImagenRequestDto dto) {
        return imagenService.agregar(propiedadId, dto);
    }

    @DeleteMapping("/{imagenId}")
    public void eliminar(@PathVariable Long imagenId) {
        imagenService.eliminar(imagenId);
    }
}
