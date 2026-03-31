package com.proyectofinalback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinalback.entities.Empleados;
import com.proyectofinalback.entities.TipoRol;

@Service
public interface EmpleadoService {
    
    Empleados crearEmpleado(Empleados empleado);

    List<Empleados> listarEmpleados();

    Empleados obtenerPorId(Long id);

    Empleados buscarPorUsaurio(String usuario);

    Empleados buscarPorEmail(String email);

    List<Empleados> listarPorRol(TipoRol rol);
    List<Empleados> buscarPorRol(TipoRol rol);

    
}
