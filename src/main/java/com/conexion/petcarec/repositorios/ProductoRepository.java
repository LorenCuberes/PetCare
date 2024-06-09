package com.conexion.petcarec.repositorios;


import com.conexion.petcarec.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Producto findBycodigoproducto(String codigoproducto);
}