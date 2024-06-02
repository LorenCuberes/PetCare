package com.conexion.petcarec.controller;

import com.conexion.petcarec.modelo.Cliente;
import com.conexion.petcarec.modelo.RegistroCliente;
import com.conexion.petcarec.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @PostMapping("/registrarCliente")
    public ResponseEntity<?> registrar(@RequestBody RegistroCliente registroCliente) {
        try {
            Cliente cliente = clienteService.registrarCliente(registroCliente);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cliente registrado con éxito");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
