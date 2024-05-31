package com.conexion.petcarec.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
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
