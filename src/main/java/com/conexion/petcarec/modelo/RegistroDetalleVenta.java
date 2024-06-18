package com.conexion.petcarec.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroDetalleVenta {

    private Integer idproducto;
    private Integer cantidad;
    private Integer idpedido;
}
