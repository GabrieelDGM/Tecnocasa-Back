package com.proyectofinalback.controller;
import com.proyectofinalback.dto.request.UsuarioRequestDto;
import com.proyectofinalback.dto.response.UsuarioResponseDto;
import com.proyectofinalback.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "Endpoints para gestionar usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @Operation(summary = "Crear un nuevo usuario")
    @PostMapping
    public UsuarioResponseDto crearUsuario(@RequestBody UsuarioRequestDto dto) {
        return service.crearUsuario(dto);
    }

    @Operation(summary = "Obtener todos los usuarios")
    @GetMapping
    public List<UsuarioResponseDto> obtenerUsuarios() {
        return service.obtenerUsuarios();
    }

    @Operation(summary = "Obtener usuario por ID")
    @GetMapping("/{id}")
    public UsuarioResponseDto obtenerPorId(@PathVariable Long id) {
        return service.obtenerUsuarioPorId(id);
    }

    @Operation(summary = "Buscar usuario por nombre de usuario")
    @GetMapping("/buscar/usuario")
    public UsuarioResponseDto buscarPorUsuario(@RequestParam String usuario) {
        return service.buscarPorUsuario(usuario);
    }

    @Operation(summary = "Buscar usuario por correo")
    @GetMapping("/buscar/correo")
    public UsuarioResponseDto buscarPorCorreo(@RequestParam String correo) {
        return service.buscarPorCorreo(correo);
    }

    @Operation(summary = "Buscar usuario por DNI")
    @GetMapping("/buscar/dni")
    public UsuarioResponseDto buscarPorDni(@RequestParam String dni) {
        return service.buscarPorDni(dni);
    }
}