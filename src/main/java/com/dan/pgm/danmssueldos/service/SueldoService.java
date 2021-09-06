package com.dan.pgm.danmssueldos.service;

import com.dan.pgm.danmssueldos.model.ReciboSueldo;

public interface SueldoService {

    ReciboSueldo liquidarSueldoByEmpleadoId(Integer empleadoId);
}
