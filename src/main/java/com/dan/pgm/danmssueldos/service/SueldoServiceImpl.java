package com.dan.pgm.danmssueldos.service;

import com.dan.pgm.danmssueldos.database.SueldoRepository;
import com.dan.pgm.danmssueldos.dto.EmpleadoDTO;
import com.dan.pgm.danmssueldos.model.Empleado;
import com.dan.pgm.danmssueldos.model.ReciboSueldo;
import com.dan.pgm.danmssueldos.model.Venta;
import com.dan.pgm.danmssueldos.service.SueldoService;
import com.dan.pgm.danmssueldos.service.VentaService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SueldoServiceImpl implements SueldoService {

    @Autowired
    SueldoRepository sueldoRepository;

    @Autowired
    VentaService ventaService;


    @Override
    public ReciboSueldo liquidarSueldoByEmpleadoId(Integer empleadoId) {

        EmpleadoDTO empleadoDTOObtenido = ventaService.getEmpleadoById(empleadoId);

        if(empleadoDTOObtenido == null){
            throw new RuntimeException("No se encontre un empleado con el id: " + empleadoId);
        } else {
            Double montoTotal = 40000.0;
            Long cantVentas = ventaService.cantVentasDelMesByEmpleado(empleadoId);
            EmpleadoDTO mejorVendedorDelMes = ventaService.mejorVendedorDelMes();

            if(mejorVendedorDelMes.getId() == empleadoId){
                montoTotal+=6000.0;
            }

            montoTotal+=cantVentas*100.0;

            ReciboSueldo recibo = new ReciboSueldo(montoTotal, empleadoId);
            sueldoRepository.save(recibo);
            return recibo;
        }

    }


    public List<ReciboSueldo> liquidarSueldosEmpleados(){
        List<EmpleadoDTO> empleadosAliquidar = ventaService.getAllEmpleados();
        List<ReciboSueldo> recibos = new ArrayList<>();

        for(EmpleadoDTO e: empleadosAliquidar){
            recibos.add(this.liquidarSueldoByEmpleadoId(e.getId()));
        }

        return recibos;
    }
}
