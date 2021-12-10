package com.victor.cuentadigital.repository;

import com.victor.cuentadigital.entity.CuentaAhorros;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaAhorrosRepository extends CrudRepository<CuentaAhorros, Long> {
}
