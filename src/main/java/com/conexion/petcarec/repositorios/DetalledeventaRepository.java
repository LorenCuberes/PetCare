package com.conexion.petcarec.repositorios;

import com.conexion.petcarec.modelo.Detalledeventa;
import com.conexion.petcarec.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalledeventaRepository extends JpaRepository<Detalledeventa, Integer> {
    List<Detalledeventa> findByidpedido(Venta idVenta);
}
