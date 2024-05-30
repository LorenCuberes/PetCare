package com.conexion.petcarec.repositorios;

import com.conexion.petcarec.modelo.Persona;
import com.conexion.petcarec.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByEmail(String email);
}
