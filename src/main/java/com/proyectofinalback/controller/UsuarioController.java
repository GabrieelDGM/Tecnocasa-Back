package com.proyectofinalback.controller;

import com.proyectofinalback.dto.request.UsuarioRequestDto;
import com.proyectofinalback.dto.request.UsuarioLoginRequestDto;
import com.proyectofinalback.dto.response.UsuarioResponseDto;
import com.proyectofinalback.dto.response.UsuarioLoginResponseDto;
import com.proyectofinalback.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "Endpoints para gestionar usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // REGISTRO
    @Operation(summary = "Crear un nuevo usuario")
    @PostMapping
    public UsuarioResponseDto crearUsuario(@RequestBody UsuarioRequestDto dto) {
        return service.crearUsuario(dto);
    }

    // LOGIN
    @Operation(summary = "Iniciar sesión de usuario")
    @PostMapping("/login")
    public UsuarioLoginResponseDto login(@RequestBody UsuarioLoginRequestDto dto) {
        return service.login(dto);
    }

    // LISTAR
    @Operation(summary = "Obtener todos los usuarios")
    @GetMapping
    public List<UsuarioResponseDto> obtenerUsuarios() {
        return service.obtenerUsuarios();
    }

    // OBTENER POR ID
    @Operation(summary = "Obtener usuario por ID")
    @GetMapping("/{id}")
    public UsuarioResponseDto obtenerPorId(@PathVariable Long id) {
        return service.obtenerUsuarioPorId(id);
    }

    // BUSCAR POR USUARIO
    @Operation(summary = "Buscar usuario por nombre de usuario")
    @GetMapping("/buscar/usuario")
    public UsuarioResponseDto buscarPorUsuario(@RequestParam String usuario) {
        return service.buscarPorUsuario(usuario);
    }

    // BUSCAR POR CORREO
    @Operation(summary = "Buscar usuario por correo")
    @GetMapping("/buscar/correo")
    public UsuarioResponseDto buscarPorCorreo(@RequestParam String correo) {
        return service.buscarPorCorreo(correo);
    }

    // BUSCAR POR DNI
    @Operation(summary = "Buscar usuario por DNI")
    @GetMapping("/buscar/dni")
    public UsuarioResponseDto buscarPorDni(@RequestParam String dni) {
        return service.buscarPorDni(dni);
    }
}
