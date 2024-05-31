package com.conexion.petcarec.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRespuesta {
    private String email;
    private String nombre;
    private String apellido;
    private String denominacion;
}
