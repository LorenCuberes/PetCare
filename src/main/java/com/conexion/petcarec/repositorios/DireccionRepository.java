package com.conexion.petcarec.repositorios;

import com.conexion.petcarec.modelo.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
    Direccion findByCalle(String Calle);
}
