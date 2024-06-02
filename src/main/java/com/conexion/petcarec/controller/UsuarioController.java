package com.conexion.petcarec.controller;

import com.conexion.petcarec.modelo.Login;
import com.conexion.petcarec.modelo.RegistroUsuario;
import com.conexion.petcarec.modelo.Usuario;
import com.conexion.petcarec.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;



    @GetMapping("/usuarios")
    private ResponseEntity<List<Usuario>> getAllUsuarios() {
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
            return ResponseEntity.ok(usuarioService.usuarioRespuesta(email,contrasena));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody RegistroUsuario registroUsuario) {
        try {
            Usuario usuario = usuarioService.registrarUsuario(registroUsuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado con éxito");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body("Error de formato JSON: " + ex.getMessage());
    }


}
