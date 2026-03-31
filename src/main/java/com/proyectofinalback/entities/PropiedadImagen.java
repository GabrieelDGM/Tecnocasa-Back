package com.proyectofinalback.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "propiedad_imagenes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropiedadImagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propiedad_id", nullable = false)
    private Propiedades propiedad;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String url;
}
