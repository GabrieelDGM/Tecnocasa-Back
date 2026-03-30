package com.proyectofinalback.mapper;

import org.springframework.stereotype.Component;

import com.proyectofinalback.dto.request.EmpleadoRequestDto;
import com.proyectofinalback.dto.response.EmpleadoResponseDto;
import com.proyectofinalback.entities.Empleados;
import com.proyectofinalback.entities.TipoRol;

@Component
public class EmpleadoMapper {

    public Empleados toEntity(EmpleadoRequestDto dto) {
        Empleados empleado = new Empleados();
        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setUsuario(dto.getUsuario());
        empleado.setEmail(dto.getEmail());
        empleado.setContrasena(dto.getContrasena());
        empleado.setTelefono(dto.getTelefono());
        empleado.setRol(TipoRol.valueOf(dto.getRol()));
        return empleado;
    }

    public EmpleadoResponseDto toDto(Empleados empleado) {
        EmpleadoResponseDto dto = new EmpleadoResponseDto();
        dto.setId(empleado.getId());
        dto.setNombre(empleado.getNombre());
        dto.setApellido(empleado.getApellido());
        dto.setUsuario(empleado.getUsuario());
        dto.setEmail(empleado.getEmail());
        dto.setTelefono(empleado.getTelefono());
        dto.setRol(empleado.getRol().name());
        return dto;
    }
}
