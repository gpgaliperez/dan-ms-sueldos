package com.dan.pgm.danmssueldos.rest;

import com.dan.pgm.danmssueldos.dto.PedidoDTO;
import com.dan.pgm.danmssueldos.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/venta")
public class VentaController {

    @Autowired
    VentaService ventaService;

    @PostMapping("/crearVenta/{empleadoId}")
    public ResponseEntity<?> crearVenta(@RequestBody PedidoDTO pedidoDTO, @PathVariable Integer empleadoId){

        return new ResponseEntity<>(ventaService.crearVenta(pedidoDTO, empleadoId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodas(){

        return new ResponseEntity<>(ventaService.obtenerVentas(), HttpStatus.OK);
    }

    @GetMapping("/ventasByEmpleado/{empleadoId}")
    public ResponseEntity<?> obtenerByEmpleado(@PathVariable Integer empleadoId){

        return new ResponseEntity<>(ventaService.obtenerVentasByEmpleado(empleadoId), HttpStatus.OK);
    }

    @GetMapping("/empleadoDelMes")
    public ResponseEntity<?> obtenerByIdEmpleado(){

        return new ResponseEntity<>(ventaService.mejorVendedorDelMes(), HttpStatus.OK);
    }
}
