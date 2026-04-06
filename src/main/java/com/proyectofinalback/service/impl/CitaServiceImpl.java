package com.proyectofinalback.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinalback.dto.request.CitaRequestDto;
import com.proyectofinalback.dto.response.CitaResponseDto;
import com.proyectofinalback.entities.Cita;
import com.proyectofinalback.entities.EstadoCita;
import com.proyectofinalback.entities.TipoPropiedad;
import com.proyectofinalback.entities.TipoRol;
import com.proyectofinalback.mapper.CitaMapper;
import com.proyectofinalback.repository.CitaRepository;
import com.proyectofinalback.repository.EmpleadoRepository;
import com.proyectofinalback.repository.PropiedadesRepository;
import com.proyectofinalback.repository.UsuarioRepository;
import com.proyectofinalback.service.CitaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepo;
    private final PropiedadesRepository propiedadesRepo;
    private final EmpleadoRepository empleadoRepo;  
    private final UsuarioRepository usuarioRepo;

    @Override
    public CitaResponseDto crear(CitaRequestDto dto) {

        var usuario = usuarioRepo.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        var propiedad = propiedadesRepo.findById(dto.getPropiedadId())
                .orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));

        var cita = CitaMapper.toEntity(dto, propiedad, usuario);

        cita.setEstado(EstadoCita.PENDIENTE);

        citaRepo.save(cita);

        return CitaMapper.toDto(cita);
    }

    @Override
    public List<CitaResponseDto> listarPorGestor(Long empleadoId) {

        var emp = empleadoRepo.findById(empleadoId)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        if (emp.getRol() != TipoRol.GESTOR) {
            throw new RuntimeException("Solo los gestores pueden ver citas");
        }

        TipoPropiedad tipo = emp.getTipoGestor();

        List<Cita> citas = citaRepo.findByTipo(tipo);

        return citas.stream()
                .map(CitaMapper::toDto)
                .toList();
    }

    @Override
    public CitaResponseDto obtenerPorId(Long id) {
        var cita = citaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        return CitaMapper.toDto(cita);
    }

    @Override
    public CitaResponseDto confirmar(Long id) {
        var cita = citaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        cita.setEstado(EstadoCita.CONFIRMADA);
        citaRepo.save(cita);

        return CitaMapper.toDto(cita);
    }

    @Override
    public void eliminar(Long id) {
        if (!citaRepo.existsById(id)) {
            throw new RuntimeException("Cita no encontrada");
        }
        citaRepo.deleteById(id);
    }
}
