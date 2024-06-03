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
    private String calle;
    private String departamento;
    private Integer numCalle;
    private String barrio;
    private Integer piso;
    private Integer idProvincia;
    private String descripcionLocalidad;
}
