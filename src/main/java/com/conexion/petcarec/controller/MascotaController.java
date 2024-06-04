package com.conexion.petcarec.controller;


import com.conexion.petcarec.modelo.RegistroMascota;
import com.conexion.petcarec.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mascota")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;


    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody RegistroMascota registroMascota) {
        try {
            mascotaService.registrarMascota(registroMascota);
            return ResponseEntity.status(HttpStatus.CREATED).body("Mascota registrada con éxito");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}