package com.proyectofinalback.entities;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")

public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único del usuario", example = "1")
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank
    @Schema(description = "Nombre de usuario único", example = "gabriel23")
    private String usuario;

    @Column(nullable = false, length = 100)
    @NotBlank
    @Schema(description = "Nombre del usuario", example = "Gabriel")
    private String nombre;

    @Column(nullable = false, length = 100)
    @NotBlank
    @Schema(description = "Apellido del usuario", example = "Martínez")
    private String apellido;

    @Column(nullable = false, unique = true, length = 20)
    @NotBlank
    @Schema(description = "DNI del usuario", example = "12345678A")
    private String dni;

    @Column(length = 255)
    @Schema(description = "Dirección del usuario", example = "Calle Mayor 123")
    private String direccion;

    @Column(length = 10)
    @Schema(description = "Código postal", example = "28001")
    private String codigoPostal;

    @Column(length = 20)
    @Schema(description = "Número de teléfono", example = "600123456")
    private String telefono;

    @Column(nullable = false, unique = true, length = 150)
    @Email
    @NotBlank
    @Schema(description = "Correo electrónico del usuario", example = "gabriel@example.com")
    private String correo;

    @Column(nullable = false, length = 255)
    @NotBlank
    @Schema(description = "Contraseña hasheada del usuario", example = "$2a$10$...")
    private String contrasena;

    @Column(name = "fecha_registro", updatable = false)
    @Schema(description = "Fecha de registro del usuario")
    private java.sql.Timestamp fechaRegistro;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = new java.sql.Timestamp(System.currentTimeMillis());
    }
}
