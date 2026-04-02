package com.proyectofinalback.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinalback.dto.request.EmpleadoLoginRequestDto;
import com.proyectofinalback.dto.request.EmpleadoRequestDto;
import com.proyectofinalback.dto.response.EmpleadoResponseDto;
import com.proyectofinalback.entities.Empleados;
import com.proyectofinalback.entities.TipoRol;
import com.proyectofinalback.mapper.EmpleadoMapper;
import com.proyectofinalback.service.EmpleadoService;

import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/empleados")
public class EmpleadosController {

    private final EmpleadoService empleadoService;
    private final EmpleadoMapper empleadoMapper;

    public EmpleadosController(EmpleadoService empleadoService, EmpleadoMapper empleadoMapper) {
        this.empleadoService = empleadoService;
        this.empleadoMapper = empleadoMapper;
    }

    // Crear empleado
    @PostMapping
    public ResponseEntity<EmpleadoResponseDto> crearEmpleado(@RequestBody EmpleadoRequestDto empleadoRequestDto) {
        Empleados empleado = empleadoMapper.toEntity(empleadoRequestDto);
        Empleados nuevoEmpleado = empleadoService.crearEmpleado(empleado);
        EmpleadoResponseDto responseDto = empleadoMapper.toDto(nuevoEmpleado);
        return ResponseEntity.ok(responseDto);
    }

    // Lista de empleados
    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDto>> listarEmpleados() {
        List<EmpleadoResponseDto> lista = empleadoService.listarEmpleados()
                .stream()
                .map(empleadoMapper::toDto)
                .toList();

        return ResponseEntity.ok(lista);
    }

    // Obtener empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDto> obtenerPorId(@PathVariable Long id) {
        Empleados empleado = empleadoService.obtenerPorId(id);
        if (empleado != null) {
            EmpleadoResponseDto responseDto = empleadoMapper.toDto(empleado);
            return ResponseEntity.ok(responseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar por usuario
    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<EmpleadoResponseDto> buscarPorUsuario(@PathVariable String usuario) {
        Empleados empleado = empleadoService.buscarPorUsaurio(usuario);

        if (empleado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empleadoMapper.toDto(empleado));
    }

    // Buscar por correo
    @GetMapping("/correo/{correo}")
    public ResponseEntity<EmpleadoResponseDto> buscarPorEmail(@PathVariable String correo) {
        Empleados empleado = empleadoService.buscarPorEmail(correo);

        if (empleado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empleadoMapper.toDto(empleado));
    }

    // Buscar por rol
    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<EmpleadoResponseDto>> buscarPorRol(@PathVariable TipoRol rol) {
        List<EmpleadoResponseDto> lista = empleadoService.buscarPorRol(rol)
                .stream()
                .map(empleadoMapper::toDto)
                .toList();

        return ResponseEntity.ok(lista);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<EmpleadoResponseDto> login(@RequestBody EmpleadoLoginRequestDto request) {

        Empleados empleado = empleadoService.login(request.getUsuario(), request.getContrasena());

        if (empleado == null) {
            return ResponseEntity.status(401).build();
        }

        return ResponseEntity.ok(empleadoMapper.toDto(empleado));
    }

}
