package com.conexion.petcarec.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroCliente {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaDeNacimiento;
    //falta direccion
}
