package com.conexion.petcarec.modelo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ActualizarStock {
    private Integer id;
    private Integer cantidad;

}
