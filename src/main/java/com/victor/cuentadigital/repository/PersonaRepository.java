package com.victor.cuentadigital.repository;

import com.victor.cuentadigital.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, String> {
}
