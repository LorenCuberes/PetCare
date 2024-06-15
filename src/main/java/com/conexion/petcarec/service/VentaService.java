package com.conexion.petcarec.service;

import com.conexion.petcarec.modelo.Producto;
import com.conexion.petcarec.modelo.RegistroProducto;
import com.conexion.petcarec.modelo.RegistroVenta;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class VentaService {

    @Transactional
    public Producto registrarventa(RegistroVenta registroventa ) {
    return null;
    }
}
