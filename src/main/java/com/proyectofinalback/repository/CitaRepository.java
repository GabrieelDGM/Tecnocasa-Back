package com.proyectofinalback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyectofinalback.entities.Cita;
import com.proyectofinalback.entities.TipoPropiedad;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    @Query("""
                SELECT c
                FROM Cita c
                JOIN c.propiedad p
                WHERE p.tipo = :tipo
            """)
    List<Cita> findByTipo(@Param("tipo") TipoPropiedad tipo);
}
