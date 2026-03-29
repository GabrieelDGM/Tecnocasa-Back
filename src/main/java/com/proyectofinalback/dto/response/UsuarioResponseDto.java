package com.proyectofinalback.dto.response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para la respuesta de un usuario")

public class UsuarioResponseDto {
    @Schema(description= "Es un identificador unico para cada usuario")
    private Long id;

    @Schema(description= "el nombre el usuario tiene que ser unico")
    private String usuario;

    @Schema(description="el nombre del usuario")
     private String nombre;

    @Schema(description="el apellido del usuario")
    private String apellido;

    @Schema(description="el dni del usuario tiene que ser unico")
    private String dni;

    @Schema(description="la direccion del usuario")
    private String direccion;

    @Schema(description="el codigo postal del usuario")
    private String codigoPostal;

    @Schema(description="el telefono del usuario")
    private String telefono;

    @Schema(description="el correo del usuario tiene que ser unico")
    private String correo;

    @Schema(description="la fecha de registro del usuario")
    private java.sql.Timestamp fechaRegistro;
}