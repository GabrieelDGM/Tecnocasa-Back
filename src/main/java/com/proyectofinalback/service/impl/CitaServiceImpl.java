package com.proyectofinalback.service.impl;

import com.proyectofinalback.dto.request.CitaRequestDto;
import com.proyectofinalback.dto.response.CitaResponseDto;
import com.proyectofinalback.entities.Cita;
import com.proyectofinalback.entities.TipoRol;
import com.proyectofinalback.mapper.CitaMapper;
import com.proyectofinalback.repository.CitaRepository;
import com.proyectofinalback.repository.EmpleadoRepository;
import com.proyectofinalback.repository.PropiedadesRepository;
import com.proyectofinalback.repository.UsuarioRepository;
import com.proyectofinalback.service.CitaService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepo;
    private final PropiedadesRepository propiedadesRepo;
    private final EmpleadoRepository empleadoRepo;
    private final UsuarioRepository usuarioRepo;

   @Override
public CitaResponseDto crear(CitaRequestDto dto) {
    if (dto.getUsuarioId() == null) {
        throw new RuntimeException("Debes iniciar sesión para agendar una cita");
    }

    var usuario = usuarioRepo.findById(dto.getUsuarioId())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    var propiedad = propiedadesRepo.findById(dto.getPropiedadId())
            .orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));

    var cita = CitaMapper.toEntity(dto, propiedad, usuario);
    citaRepo.save(cita);

    return CitaMapper.toDto(cita);
    }

    @Override
    public List<CitaResponseDto> listarPorGestor(Long empleadoId) {
        var emp = empleadoRepo.findById(empleadoId)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        if (!emp.getRol().equals(TipoRol.GESTOR)) {
            throw new RuntimeException("Solo los gestores pueden ver citas");
        }

        List<Cita> citas = citaRepo.findAll();

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
}
