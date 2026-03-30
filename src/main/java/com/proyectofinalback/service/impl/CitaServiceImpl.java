package com.proyectofinalback.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinalback.entities.Cita;
import com.proyectofinalback.repository.CitaRepository;
import com.proyectofinalback.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public Cita creaCita(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public List<Cita> listaCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Cita obtenerPorId(Long id) {
        return citaRepository.findById(id).orElse(null);
    }
}
