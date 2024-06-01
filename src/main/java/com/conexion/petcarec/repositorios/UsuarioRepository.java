package com.conexion.petcarec.repositorios;




import com.conexion.petcarec.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByidpersona_Email(String email);
    Usuario findBycontrasena(String contrasena);
    }