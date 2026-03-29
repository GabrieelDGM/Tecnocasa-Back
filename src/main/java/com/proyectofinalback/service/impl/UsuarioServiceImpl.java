package com.proyectofinalback.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proyectofinalback.dto.request.UsuarioRequestDto;
import com.proyectofinalback.dto.response.UsuarioResponseDto;
import com.proyectofinalback.entities.Usuarios;
import com.proyectofinalback.mapper.UsuarioMapper;
import com.proyectofinalback.repository.UsuarioRepository;
import com.proyectofinalback.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioServiceImpl(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UsuarioResponseDto crearUsuario(UsuarioRequestDto usuarioRequestDto) {
        Usuarios usuario = mapper.toEntity(usuarioRequestDto);
        Usuarios usuarioGuardado = repository.save(usuario);
        return mapper.toDto(usuarioGuardado);
    }

    @Override
    public List<UsuarioResponseDto> obtenerUsuarios() {
        List<Usuarios> usuarios = repository.findAll();
        return usuarios.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDto obtenerUsuarioPorId(Long id) {
        Usuarios usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return mapper.toDto(usuario);
    }
    @Override
    public UsuarioResponseDto buscarPorUsuario(String usuario) {
        Usuarios usuarioEncontrado = repository.findByUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return mapper.toDto(usuarioEncontrado);
    }

    @Override
    public UsuarioResponseDto buscarPorCorreo(String correo) {
        Usuarios usuarioEncontrado = repository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return mapper.toDto(usuarioEncontrado);
    }

    @Override
    public UsuarioResponseDto buscarPorDni(String dni) {
        Usuarios usuarioEncontrado = repository.findByDni(dni)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return mapper.toDto(usuarioEncontrado);
    }
}