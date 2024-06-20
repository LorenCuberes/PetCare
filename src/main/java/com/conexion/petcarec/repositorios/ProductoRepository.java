package com.conexion.petcarec.repositorios;


import com.conexion.petcarec.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Producto findBycodigoproducto(String codigoproducto);
    Optional<Producto> findById(Integer id);
}