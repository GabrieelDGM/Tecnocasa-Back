package com.proyectofinalback.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinalback.entities.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByUsuario(String usuario);
    Optional<Usuarios> findByCorreo(String correo);
    Optional<Usuarios> findByDni(String dni);

}
