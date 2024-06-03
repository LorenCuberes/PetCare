package com.conexion.petcarec.controller;

import com.conexion.petcarec.modelo.*;
import com.conexion.petcarec.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody RegistroCliente registroCliente) {
        String email = registroCliente.getEmail();
        boolean verificado= clienteService.VerificarCliente(email);
        if (verificado) {
            try {
                clienteService.registrarCliente(registroCliente);
                return ResponseEntity.status(HttpStatus.CREATED).body("Cliente registrado con éxito");
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este email ya existe");
        }
    }
    @GetMapping("/pais")
    private ResponseEntity<List<Pais>> getAllPais() {
        return ResponseEntity.ok(clienteService.getAllPais());
    }
    @GetMapping("/provincia")
    private ResponseEntity<List<Provincia>> getAllProvincia() {
        return ResponseEntity.ok(clienteService.getAllProvincia());
    }

}
