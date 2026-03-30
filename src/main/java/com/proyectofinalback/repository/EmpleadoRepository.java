package com.proyectofinalback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinalback.entities.Empleados;
import com.proyectofinalback.entities.TipoRol;

public interface  EmpleadoRepository extends JpaRepository<Empleados, Long> {

    Empleados findByUsuario(String usuario);

    Empleados findByEmail(String email);

    List<Empleados> findByRol(TipoRol rol);
    
}
