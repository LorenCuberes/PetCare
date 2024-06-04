package com.conexion.petcarec.repositorios;




import com.conexion.petcarec.modelo.Cuidadomascota;
import com.conexion.petcarec.modelo.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CuidadoRepository extends JpaRepository<Cuidadomascota, Integer> {

}