package com.dan.pgm.danmssueldos.service;

import com.dan.pgm.danmssueldos.model.ReciboSueldo;

import java.util.List;

public interface SueldoService {

    ReciboSueldo liquidarSueldoByEmpleadoId(Integer empleadoId);
    List<ReciboSueldo> liquidarSueldosEmpleados();
}
