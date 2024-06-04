package com.conexion.petcarec.repositorios;




import com.conexion.petcarec.modelo.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}