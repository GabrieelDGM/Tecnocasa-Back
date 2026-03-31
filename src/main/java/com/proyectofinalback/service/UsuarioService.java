package com.proyectofinalback.service;

import com.proyectofinalback.dto.response.UsuarioLoginResponseDto;
import com.proyectofinalback.dto.response.UsuarioResponseDto;
import com.proyectofinalback.dto.request.UsuarioLoginRequestDto;
import com.proyectofinalback.dto.request.UsuarioRequestDto;
import java.util.List;

public interface UsuarioService {

    UsuarioResponseDto crearUsuario(UsuarioRequestDto usuarioRequestDto);

    List<UsuarioResponseDto> obtenerUsuarios();

    UsuarioResponseDto obtenerUsuarioPorId(Long id);

    UsuarioResponseDto buscarPorUsuario(String usuario);

    UsuarioResponseDto buscarPorCorreo(String correo);

    UsuarioResponseDto buscarPorDni(String dni);

    UsuarioLoginResponseDto login(UsuarioLoginRequestDto loginDto);

}
