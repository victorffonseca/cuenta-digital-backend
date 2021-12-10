package com.victor.cuentadigital.controller;

import com.victor.cuentadigital.entity.Persona;
import com.victor.cuentadigital.service.PersonaService;
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
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping()
    @ApiOperation("Obtener todas las personas")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Persona>> obtenerPersonas() {
        return new ResponseEntity<>(personaService.obtenerPersonas(), HttpStatus.OK);
    }

    @GetMapping("/{cedula}")
    @ApiOperation("Buscar persona por cédula")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Persona no encontrada")
    })
    public ResponseEntity<Persona> obtenerPersona(@ApiParam(value = "Cédula de la persona", required = true, example = "10487412589") @PathVariable("cedula") String cedula) {
        return personaService.obtenerPersona(cedula)
                .map(persona -> new ResponseEntity<>(persona, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    @ApiOperation("Guardar una nueva persona")
    @ApiResponse(code = 201, message = "Persona creada")
    public ResponseEntity<Persona> guardar(@RequestBody Persona persona) {
        return new ResponseEntity<>(personaService.guardar(persona), HttpStatus.CREATED);
    }

    @PutMapping()
    @ApiOperation("Actualizar una persona")
    @ApiResponse(code = 200, message = "Persona actualizada")
    public ResponseEntity<Persona> actualizar(@RequestBody Persona persona) {
        return new ResponseEntity<>(personaService.guardar(persona), HttpStatus.OK);
    }

    @DeleteMapping("/{cedula}")
    @ApiOperation("Eliminar una persona")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No se ha podido eliminar")
    })
    public ResponseEntity eliminar(@ApiParam(value = "Cédula de la persona", required = true, example = "10487412589") @PathVariable("cedula") String cedula) {
        return personaService.eliminar(cedula) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
