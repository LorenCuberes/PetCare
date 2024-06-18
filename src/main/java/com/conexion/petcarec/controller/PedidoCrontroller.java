package com.conexion.petcarec.controller;

import com.conexion.petcarec.modelo.*;
import com.conexion.petcarec.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoCrontroller {
    @Autowired
    private VentaService registroVentaService;
    @Autowired
    private VentaService ventaService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrarVenta(@RequestBody RegistroVenta registroVenta) {
       registroVentaService.saveRegistroVenta(registroVenta);
        return ResponseEntity.status(HttpStatus.CREATED).body("Venta registrada con éxito");
    }
    @PostMapping("/registrodetalle")
    public ResponseEntity<?> registrarDetalleVenta(@RequestBody RegistroDetalleVenta registroDetalleVenta) {
        registroVentaService.saveDetalledeventa(registroDetalleVenta);
        return ResponseEntity.status(HttpStatus.CREATED).body("DetalledeVenta registrada con éxito");
    }
    @PostMapping("/idventasparadetalle")
    private ResponseEntity <List<Detalledeventa>> getByidventa(@RequestBody RegistroDetalleVenta detalledeventa ) {
        return ResponseEntity.ok(ventaService.getdetalleventaById(detalledeventa));
    }
    @GetMapping("/listaventas")
    private ResponseEntity<List<Venta>>  getAllVentas() {
        return ResponseEntity.ok(ventaService.getAllVentas());
    }
}
