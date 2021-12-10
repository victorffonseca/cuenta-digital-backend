package com.victor.cuentadigital.controller;

import com.victor.cuentadigital.entity.CuentaAhorros;
import com.victor.cuentadigital.service.CuentaAhorrosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
@CrossOrigin(origins = "http://localhost:4200")
public class CuentaAhorrosController {

    @Autowired
    private CuentaAhorrosService cuentaAhorrosService;

    @GetMapping()
    @ApiOperation("Obtener todas las cuentas de ahorros")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<CuentaAhorros>> obtenerCuentas() {
        return new ResponseEntity<>(cuentaAhorrosService.obtenerCuentas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar una cuenta por su número")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Cuenta de ahorros no encontrada")
    })
    public ResponseEntity<CuentaAhorros> obtenerCuenta(@ApiParam(value = "Número de la cuenta de ahorros", required = true, example = "10000000000") @PathVariable("id") long id) {
        return cuentaAhorrosService.obtenerCuenta(id)
                .map(cuenta -> new ResponseEntity<>(cuenta, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    @ApiOperation("Guardar una nueva cuenta de ahorros")
    @ApiResponse(code = 201, message = "Cuenta de ahorros creada")
    public ResponseEntity<CuentaAhorros> guardar(@RequestBody CuentaAhorros cuentaAhorros) {
        return new ResponseEntity<>(cuentaAhorrosService.guardar(cuentaAhorros), HttpStatus.CREATED);
    }

    @PutMapping()
    @ApiOperation("Actualizar una cuenta de ahorros")
    @ApiResponse(code = 200, message = "Cuenta de ahorros actualizada")
    public ResponseEntity<CuentaAhorros> actualizar(@RequestBody CuentaAhorros cuentaAhorros) {
        return new ResponseEntity<>(cuentaAhorrosService.guardar(cuentaAhorros), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar una cuenta de ahorros")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No se ha podido eliminar la cuenta de ahorros")
    })
    public ResponseEntity eliminar(@ApiParam(value = "Número de la cuenta de ahorros", required = true, example = "10000000000") @PathVariable("id") long id) {
        return cuentaAhorrosService.eliminar(id) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
