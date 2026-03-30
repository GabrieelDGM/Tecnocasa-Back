package com.proyectofinalback.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinalback.entities.Empleados;
import com.proyectofinalback.entities.TipoRol;
import com.proyectofinalback.repository.EmpleadoRepository;
import com.proyectofinalback.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public Empleados crearEmpleado(Empleados empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleados> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleados obtenerPorId(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleados buscarPorUsaurio(String usuario) {
        return empleadoRepository.findByUsuario(usuario); 
    }

    @Override
    public Empleados buscarPorEmail(String email) {
        return empleadoRepository.findByEmail(email);
    }

    @Override
    public List<Empleados> buscarPorRol(TipoRol rol) {
        return empleadoRepository.findByRol(rol);
    }

    @Override
    public List<Empleados> listarPorRol(TipoRol rol) {
        return empleadoRepository.findByRol(rol);
    }
    

}
