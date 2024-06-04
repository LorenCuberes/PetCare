package com.conexion.petcarec.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "mascota")
public class Mascota {
    @Id
    @Column(name = "idmascota", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "fechadenacimiento")
    private LocalDate fechadenacimiento;

    @Column(name = "peso", precision = 10, scale = 2)
    private BigDecimal peso;

    @Column(name = "tamano", length = 50)
    private String tamano;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idanimal", nullable = false)
    private Animal idanimal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idraza")
    private Raza idraza;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcuidado")
    private Cuidadomascota idcuidado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcliente", nullable = false)
    private Cliente idcliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idficha")
    private Fichaestadia idficha;

}