package com.victor.cuentadigital.service;

import com.victor.cuentadigital.entity.Persona;
import com.victor.cuentadigital.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> obtenerPersonas() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    public Optional<Persona> obtenerPersona(String cedula) {
        return personaRepository.findById(cedula);
    }

    @Override
    public Persona guardar(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public boolean eliminar(String cedula) {
        return obtenerPersona(cedula).map(persona -> {
            personaRepository.deleteById(cedula);
            return Boolean.TRUE;
        }).orElse(Boolean.FALSE);
    }
}
