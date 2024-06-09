package com.conexion.petcarec.repositorios;




import com.conexion.petcarec.modelo.Animal;
import com.conexion.petcarec.modelo.Categoriaproducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoriaproducto, Integer> {

}