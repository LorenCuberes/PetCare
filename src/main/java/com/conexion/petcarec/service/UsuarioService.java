package com.conexion.petcarec.service;

import com.conexion.petcarec.modelo.*;
import com.conexion.petcarec.repositorios.PersonaRepository;
import com.conexion.petcarec.repositorios.TipousuarioRepository;
import com.conexion.petcarec.repositorios.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private  UsuarioRepository usuarioRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private TipousuarioRepository tipousuarioRepository;

    public  List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
    public boolean autenticarUsuario(String email, String contrasena) {
        Usuario usuario = usuarioRepository.findByidpersona_Email(email);
        if ( usuario!= null && usuario.getContrasena().equals(contrasena)) {
            return true; // Autenticación exitosa
        }
        return false; // Autenticación fallida
    }

    public UsuarioRespuesta usuarioRespuesta(String email, String contrasena) {
        Persona persona = personaRepository.findByEmail(email);
        Usuario usuario1 = usuarioRepository.findBycontrasena(contrasena);



        if (persona != null && usuario1 != null) {
            return new UsuarioRespuesta(
                    persona.getEmail(),
                    persona.getNombre(),
                    persona.getApellido(),
                    usuario1.getIdtipousuario().getDenominacion()
            );

        }
        return null;
    }
    @Transactional
    public Usuario registrarUsuario(RegistroUsuario registroUsuario) {
        // Crear la entidad Persona
        System.out.println(registroUsuario);
        Persona persona = new Persona();
        persona.setNombre(registroUsuario.getNombre());
        persona.setApellido(registroUsuario.getApellido());
        persona.setEmail(registroUsuario.getEmail());
        persona.setTelefono(registroUsuario.getTelefono());
        persona.setFechadenacimiento(registroUsuario.getFechaDeNacimiento());

        // Guardar la entidad Persona
        persona = personaRepository.save(persona);

        // Obtener el tipo de usuario
        Tipodeusuario tipodeusuario = tipousuarioRepository.findById(registroUsuario.getIdTipoUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de usuario no válido"));

        // Crear la entidad Usuario
        Usuario usuario = new Usuario();
        usuario.setContrasena(registroUsuario.getContrasena());
        usuario.setIdpersona(persona);
        usuario.setIdtipousuario(tipodeusuario);
        usuario.setEstado('A'); // Asumimos que el estado inicial es 'A' (Activo)

        // Guardar la entidad Usuario
        return usuarioRepository.save(usuario);
    }
    public boolean VerificarUsuario(String email) {
        Usuario usuario = usuarioRepository.findByidpersona_Email(email);
        if ( usuario == null) {
            return true; // Autenticación exitosa
        }
        return false; // Autenticación fallida
    }

}
