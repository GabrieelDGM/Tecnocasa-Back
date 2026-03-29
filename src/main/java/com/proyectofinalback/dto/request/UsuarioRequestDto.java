package com.proyectofinalback.dto.request;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para la creación o actualización de un usuario")

public class UsuarioRequestDto {
    @NotBlank
    @Schema(description= "el nombre el usuario tiene que ser unico")
    private String usuario;

    @NotBlank
     @Schema(description="el nombre del usuario")
     private String nombre;

    @NotBlank
    @Schema(description="el apellido del usuario")
    private String apellido;

    @NotBlank
    @Schema(description="el dni del usuario tiene que ser unico")
    private String dni;

    @Schema(description="la direccion del usuario")
    private String direccion;

    @Schema(description="el codigo postal del usuario")
    private String codigoPostal;

    @Schema(description="el telefono del usuario")
    private String telefono;

    @Email
    @NotBlank
    @Schema(description="el correo del usuario tiene que ser unico")
    private String correo;
    
    @NotBlank
    @Schema(description="la contraseña del usuario")
    private String contrasena;
    

}