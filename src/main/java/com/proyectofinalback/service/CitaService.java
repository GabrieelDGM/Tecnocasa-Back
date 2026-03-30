package com.proyectofinalback.service;

import java.util.List;

import com.proyectofinalback.entities.Cita;

public interface CitaService {

    Cita creaCita(Cita cita);
    List<Cita> listaCitas();
    Cita obtenerPorId(Long id);
    
}
