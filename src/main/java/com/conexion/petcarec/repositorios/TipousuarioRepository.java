package com.conexion.petcarec.repositorios;


import com.conexion.petcarec.modelo.Tipodeusuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipousuarioRepository extends JpaRepository<Tipodeusuario, Integer> {
}
