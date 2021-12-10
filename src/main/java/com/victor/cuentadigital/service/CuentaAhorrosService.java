package com.victor.cuentadigital.service;

import com.victor.cuentadigital.entity.CuentaAhorros;

import java.util.List;
import java.util.Optional;

public interface CuentaAhorrosService {

    List<CuentaAhorros> obtenerCuentas();
    Optional<CuentaAhorros> obtenerCuenta(Long id);
    CuentaAhorros guardar(CuentaAhorros cuentaAhorros);
    boolean eliminar(Long id);
}
