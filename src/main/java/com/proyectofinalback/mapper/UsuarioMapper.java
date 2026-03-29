package com.proyectofinalback.mapper;

import org.springframework.stereotype.Component;

import com.proyectofinalback.dto.request.UsuarioRequestDto;
import com.proyectofinalback.dto.response.UsuarioResponseDto;
import com.proyectofinalback.entities.Usuarios;

import lombok.Data;

@Data
@Component
public class UsuarioMapper {

    public Usuarios toEntity(UsuarioRequestDto dto) {
        Usuarios usuario = new Usuarios();
        usuario.setUsuario(dto.getUsuario());
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setDni(dto.getDni());
        usuario.setDireccion(dto.getDireccion());
        usuario.setCodigoPostal(dto.getCodigoPostal());
        usuario.setTelefono(dto.getTelefono());
        usuario.setCorreo(dto.getCorreo());
        usuario.setContrasena(dto.getContrasena());
        return usuario;
    }

    public UsuarioResponseDto toResponse(Usuarios usuario) {
        UsuarioResponseDto dto = new UsuarioResponseDto();
        dto.setId(usuario.getId());
        dto.setUsuario(usuario.getUsuario());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setDni(usuario.getDni());
        dto.setDireccion(usuario.getDireccion());
        dto.setCodigoPostal(usuario.getCodigoPostal());
        dto.setTelefono(usuario.getTelefono());
        dto.setCorreo(usuario.getCorreo());
        dto.setFechaRegistro(usuario.getFechaRegistro());
        return dto;
    }

    public UsuarioResponseDto toDto(Usuarios usuario) {
        return toResponse(usuario);
    }
}