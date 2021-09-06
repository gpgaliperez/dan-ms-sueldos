package com.dan.pgm.danmssueldos.service;

import com.dan.pgm.danmssueldos.dto.EmpleadoDTO;

import java.util.List;

public interface EmpleadoService {
    public EmpleadoDTO getEmpleadoById(Integer empleadoId);
    public List<EmpleadoDTO> getAllEmpleados();
}
