package com.conexion.petcarec.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pais")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pais {
    @Id
    @Column(name = "idpais", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

}