package com.conexion.petcarec.repositorios;




import com.conexion.petcarec.modelo.Raza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RazaRepository extends JpaRepository<Raza, Integer> {

}