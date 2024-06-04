package com.conexion.petcarec.service;


import com.conexion.petcarec.modelo.*;
import com.conexion.petcarec.repositorios.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private RazaRepository razaRepository;
    @Autowired
    private CuidadoRepository cuidadoRepository;
    @Autowired
    private FichaRepository fichaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Mascota registrarMascota(RegistroMascota registroMascota) {

// Debug: log ids
        System.out.println("Id Animal: " + registroMascota.getIdanimal());
        System.out.println("Id Raza: " + registroMascota.getIdraza());

        //se busca el animal por id
        Animal animal = animalRepository.findById(registroMascota.getIdanimal())
                .orElseThrow(() -> new IllegalArgumentException("Animal no válido"));

        //se busca la raza por id
        Raza raza = razaRepository.findById(registroMascota.getIdraza())
                .orElseThrow(() -> new IllegalArgumentException("Raza no válida"));

        /*por ahora no se va a registrar fichas de ingreso ni cuidados
        //se crea la ficha
        Fichaestadia ficha = new Fichaestadia();
        ficha.setFechaegreso(registroMascota.get());
        ficha.setFechaingresa(registroMascota.get());
        //se guarda la ficha
        ficha = FichaRepository.save(ficha);

        //se crea el cuidado
        Cuidadomascota cuidado = new Cuidadomascota();
        cuidado.setDieta(registroMascota.get());
        cuidado.setCuidado(registroMascota.get());
        //se guarda el cuidado
        cuidado = CuidadoRepository.save(cuidado);
        */

        Cliente cliente = clienteRepository.findById(1)
                .orElseThrow(() -> new IllegalArgumentException("Raza no válida"));
        //despues se puede tomar el cliente a cargo de la mascota tambien, le asigno el cliente 1 por ahora

        // Crear la entidad mascota
        Mascota mascota = new Mascota();
        mascota.setNombre(registroMascota.getNombre());
        mascota.setPeso(BigDecimal.valueOf(registroMascota.getPeso()));
        mascota.setFechadenacimiento(registroMascota.getFechaDeNacimiento());
        mascota.setTamano(registroMascota.getTamano());
        mascota.setIdraza(raza);
        mascota.setIdanimal(animal);
        mascota.setIdcliente(cliente);
        //mascota.setIdcliente(registroMascota.getIdcliente());
        //mascota.setIdcuidado(cuidado);
        //mascota.setIdficha(ficha);




        // Guardar la entidad mascota
        return mascotaRepository.save(mascota);
    }

}
