
package com.conexion.petcarec.repositorios;

import com.conexion.petcarec.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}