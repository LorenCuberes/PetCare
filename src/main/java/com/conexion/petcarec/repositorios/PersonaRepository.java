package com.conexion.petcarec.repositorios;

import com.conexion.petcarec.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Usuario, Long> {
}
