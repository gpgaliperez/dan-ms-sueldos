package com.dan.pgm.danmssueldos.rest;
import com.dan.pgm.danmssueldos.model.Empleado;
import com.dan.pgm.danmssueldos.service.EmpleadoService;
import com.dan.pgm.danmssueldos.service.SueldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/getEmpleadoById/{empleadoId}")
    public ResponseEntity<?> getEmpleadoById(@PathVariable Integer empleadoID){

        return new ResponseEntity<>(empleadoService.getEmpleadoById(empleadoID), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> liquidarSueldoByEmpleados(@PathVariable Integer empleadoID){

        return new ResponseEntity<>(empleadoService.getAllEmpleados(), HttpStatus.OK);
    }

}
