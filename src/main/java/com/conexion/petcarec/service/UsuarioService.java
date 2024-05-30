package com.conexion.petcarec.service;

import com.conexion.petcarec.modelo.Persona;
import com.conexion.petcarec.modelo.Tipodeusuario;
import com.conexion.petcarec.modelo.Usuario;
import com.conexion.petcarec.repositorios.PersonaRepository;
import com.conexion.petcarec.repositorios.TipousuarioRepository;
import com.conexion.petcarec.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private  UsuarioRepository usuarioRepository;
    @Autowired
    private TipousuarioRepository tipousuarioRepository;


    @Autowired
    private PersonaRepository personaRepository;

    public  List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
    public boolean autenticarUsuario(String email, String contrasena) {
        Usuario usuario = usuarioRepository.findByidpersona_email(email);

        if (usuario != null && usuario.getContrasena().equals(contrasena)) {

            return true; // Autenticación exitosa
        }
        return false; // Autenticación fallida
    }

    public String obtenerNombreApellido(String email) {
        Persona persona = personaRepository.findByEmail(email);

        if (persona != null) {
            return persona.getNombre() + " " + persona.getApellido()+ " " + persona.getEmail()+ " ";
        }
        return null;
    }

}
