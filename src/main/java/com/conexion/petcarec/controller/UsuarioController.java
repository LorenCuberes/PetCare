package com.conexion.petcarec.controller;

import com.conexion.petcarec.modelo.Login;
import com.conexion.petcarec.modelo.Registrar;
import com.conexion.petcarec.modelo.Usuario;
import com.conexion.petcarec.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;



    @GetMapping("/usuarios")
    private ResponseEntity<List<Usuario>> getAllClients() {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }
    @PostMapping("/ingresar")
    public ResponseEntity<?> login(@RequestBody Login login) {
        String email = login.getEmail();
        String contrasena = login.getPassword();

        // Validar la autenticación
        boolean autenticado = usuarioService.autenticarUsuario(email, contrasena);
        if (autenticado) {
            // Obtener el nombre y apellido del usuario
            String nombreApellido = usuarioService.obtenerNombreApellido(email);
            return ResponseEntity.ok(nombreApellido);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Registrar registrar) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }


}
