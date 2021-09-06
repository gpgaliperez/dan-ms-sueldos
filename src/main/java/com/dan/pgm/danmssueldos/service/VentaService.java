package com.dan.pgm.danmssueldos.service;

import com.dan.pgm.danmssueldos.dto.EmpleadoDTO;
import com.dan.pgm.danmssueldos.dto.PedidoDTO;
import com.dan.pgm.danmssueldos.dto.VentaDTO;
import com.dan.pgm.danmssueldos.model.Venta;

import java.util.List;

public interface VentaService {

    public VentaDTO crearVenta(PedidoDTO pedidoDTO, Integer empleadoId);
    public List<Venta> obtenerVentas();
    public List<Venta> obtenerVentasByEmpleado(Integer empleadoId);
    public List<Venta> obtenerVentasDelMes();
    public Long cantVentasDelMesByEmpleado(Integer empleadoId);
    public EmpleadoDTO getEmpleadoById(Integer empleadoId);
    public List<EmpleadoDTO> getAllEmpleados();
    EmpleadoDTO mejorVendedorDelMes();

}
