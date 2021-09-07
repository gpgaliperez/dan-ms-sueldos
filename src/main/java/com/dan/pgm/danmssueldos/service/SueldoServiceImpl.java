package com.dan.pgm.danmssueldos.service;

import com.dan.pgm.danmssueldos.database.SueldoRepository;
import com.dan.pgm.danmssueldos.dto.EmpleadoDTO;
import com.dan.pgm.danmssueldos.model.ReciboSueldo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SueldoServiceImpl implements SueldoService {

    @Autowired
    SueldoRepository sueldoRepository;

    @Autowired
    VentaService ventaService;

    @Autowired
    EmpleadoService empleadoService;

    @Override
    public ReciboSueldo liquidarSueldoByEmpleadoId(Integer empleadoId) {

        EmpleadoDTO empleadoDTOObtenido = empleadoService.getEmpleadoById(empleadoId);

        if(empleadoDTOObtenido == null){
            throw new RuntimeException("No se encontró un empleado con el id: " + empleadoId);
        } else {
            Double montoTotal = 40000.0; //sueldo fijo
            Long cantVentas = ventaService.cantVentasDelMesByEmpleado(empleadoId);
            EmpleadoDTO mejorVendedorDelMes = ventaService.mejorVendedorDelMes();

            if(mejorVendedorDelMes.getId() == empleadoId)
                montoTotal+=6000.0; //bonificación por empleado del mes

            montoTotal+=cantVentas*100.0; //bonificación por ventas

            ReciboSueldo recibo = new ReciboSueldo(montoTotal, empleadoId);
            sueldoRepository.save(recibo);
            return recibo;
        }
    }

    public List<ReciboSueldo> liquidarSueldosEmpleados(){
        List<EmpleadoDTO> empleadosAliquidar = empleadoService.getAllEmpleados();
        List<ReciboSueldo> recibos = new ArrayList<>();

        for(EmpleadoDTO e: empleadosAliquidar)
            recibos.add(this.liquidarSueldoByEmpleadoId(e.getId()));

        return recibos;
    }
}
