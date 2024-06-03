package com.conexion.petcarec.service;


import com.conexion.petcarec.modelo.*;
import com.conexion.petcarec.repositorios.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private DireccionRepository direccionRepository;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private ProvinciaRepository provinciaRepository;
    @Autowired
    private LocalidadRepository localidadRepository;



    public List<Pais> getAllPais() {
        return paisRepository.findAll();
    }
    public List<Provincia> getAllProvincia() {
        return provinciaRepository.findAll();
    }
    @Transactional
    public Cliente registrarCliente(RegistroCliente registroCliente) {


        Provincia provincia = provinciaRepository.findById(registroCliente.getIdProvincia())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de Provincia no válido"));

        Localidad localidad = new Localidad();
        localidad.setDescripcion(registroCliente.getDescripcionLocalidad());
        localidad.setIdprovincia(provincia);
        localidad = localidadRepository.save(localidad);


        Direccion direccion = new Direccion();
        direccion.setBarrio(registroCliente.getBarrio());
        direccion.setCalle(registroCliente.getCalle());
        direccion.setNumero(registroCliente.getNumCalle());
        direccion.setPiso(registroCliente.getPiso());
        direccion.setDepartamento(registroCliente.getDepartamento());
        direccion.setIdlocalidad(localidad);
        direccionRepository.save(direccion);

        // Crear la entidad Persona
        Persona persona = new Persona();
        persona.setNombre(registroCliente.getNombre());
        persona.setApellido(registroCliente.getApellido());
        persona.setEmail(registroCliente.getEmail());
        persona.setTelefono(registroCliente.getTelefono());
        persona.setFechadenacimiento(registroCliente.getFechaDeNacimiento());
        persona.setIddireccion(direccion);

        // Guardar la entidad Persona
        persona = personaRepository.save(persona);


        // Crear la entidad Usuario
        Cliente cliente = new Cliente();
        cliente.setIdpersona(persona);
        //le ponemos la mascota?


        // Guardar la entidad Usuario
        return clienteRepository.save(cliente);
    }


}
