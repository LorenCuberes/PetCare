package com.conexion.petcarec.repositorios;




import com.conexion.petcarec.modelo.Fichaestadia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FichaRepository extends JpaRepository<Fichaestadia, Integer> {

}