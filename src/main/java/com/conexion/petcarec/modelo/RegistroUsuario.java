package com.conexion.petcarec.modelo;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Data
public class RegistroUsuario {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaDeNacimiento;
    private String contrasena;
    private Integer idTipoUsuario;
}
