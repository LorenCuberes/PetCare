package com.conexion.petcarec.modelo;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroVenta {

    private LocalDate fechapedido;
    private String observaciones;
    private String formadepago;
    private Integer idcliente;
    private Integer idestado;

}
