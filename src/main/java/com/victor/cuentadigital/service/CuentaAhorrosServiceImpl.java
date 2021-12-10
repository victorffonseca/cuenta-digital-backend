package com.victor.cuentadigital.service;

import com.victor.cuentadigital.entity.CuentaAhorros;
import com.victor.cuentadigital.repository.CuentaAhorrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaAhorrosServiceImpl implements CuentaAhorrosService {

    @Autowired
    private CuentaAhorrosRepository cuentaAhorrosRepository;

    @Override
    public List<CuentaAhorros> obtenerCuentas() {
        return (List<CuentaAhorros>) cuentaAhorrosRepository.findAll();
    }

    @Override
    public Optional<CuentaAhorros> obtenerCuenta(Long id) {
        return cuentaAhorrosRepository.findById(id);
    }

    @Override
    public CuentaAhorros guardar(CuentaAhorros cuentaAhorros) {
        return cuentaAhorrosRepository.save(cuentaAhorros);
    }

    @Override
    public boolean eliminar(Long id) {
        return obtenerCuenta(id).map(cuenta -> {
           cuentaAhorrosRepository.deleteById(id);
           return Boolean.TRUE;
        }).orElse(Boolean.FALSE);
    }
}
