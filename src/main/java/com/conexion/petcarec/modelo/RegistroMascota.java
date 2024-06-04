package com.conexion.petcarec.modelo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Data
public class RegistroMascota {
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private Double peso;
    private String tamano;
    private Integer idraza;
    private Integer idanimal;
    private Integer idcuidado;
    private Integer idcliente;
    private Integer idficha;

}
