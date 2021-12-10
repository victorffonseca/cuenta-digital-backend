package com.victor.cuentadigital.service;

import com.victor.cuentadigital.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    List<Persona> obtenerPersonas();
    Optional<Persona> obtenerPersona(String cedula);
    Persona guardar(Persona persona);
    boolean eliminar(String cedula);
}
