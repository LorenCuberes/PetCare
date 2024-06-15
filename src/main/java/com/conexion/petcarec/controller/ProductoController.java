package com.conexion.petcarec.controller;


import com.conexion.petcarec.modelo.*;

import com.conexion.petcarec.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;


    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody RegistroProducto registroProducto) {

        String codigoproducto = registroProducto.getCodigoproducto();
        boolean verificado= productoService.VerificarProducto(codigoproducto);
        if (verificado) {
            try {
                productoService.registrarProducto(registroProducto);
                return ResponseEntity.status(HttpStatus.CREATED).body("Producto registrado con éxito");
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este código de producto ya existe");
        }
    }

    @GetMapping("/listaproductos")
    private ResponseEntity<List<Producto>>  getAllProducto() {
        return ResponseEntity.ok(productoService.getAllProducto());
    }

    @GetMapping("/categorias")
    private ResponseEntity<List<Categoriaproducto>> getAllCategoriaproducto() {
        return ResponseEntity.ok(productoService.getAllCategoriaproducto());
    }

    @PostMapping("/actualizarstock")
    public Producto actualizarStock(@RequestBody ActualizarStock actualizarStock) {
        return productoService.actualizarStock(actualizarStock.getId(), actualizarStock.getCantidad());
    }


}