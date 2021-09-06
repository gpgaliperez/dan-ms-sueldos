package com.dan.pgm.danmssueldos.service;

import com.dan.pgm.danmssueldos.database.SueldoRepository;
import com.dan.pgm.danmssueldos.dto.EmpleadoDTO;
import com.dan.pgm.danmssueldos.model.ReciboSueldo;
import com.dan.pgm.danmssueldos.service.SueldoService;
import com.dan.pgm.danmssueldos.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        }
        return null;
    }
}
