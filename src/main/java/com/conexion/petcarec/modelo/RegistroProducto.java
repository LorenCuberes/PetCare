package com.conexion.petcarec.modelo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Data
public class RegistroProducto {
    private String nombre;
    private Double precio;
    private String codigoproducto;
    private Integer stock;
    private Integer idcategoria;

}