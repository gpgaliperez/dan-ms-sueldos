package com.dan.pgm.danmssueldos.dto;

import java.time.Instant;

public class VentaDTO {

    private EmpleadoDTO empleadoDTO;
    private Double montoTotal;
    private Instant fechaVenta;
    private String estadoPedido;
    private Integer idObra;

    public VentaDTO() {
    }

    public VentaDTO(EmpleadoDTO empleadoDTO, Double montoTotal, Instant fechaVenta, String estadoPedido, Integer idObra) {
        this.empleadoDTO = empleadoDTO;
        this.montoTotal = montoTotal;
        this.fechaVenta = fechaVenta;
        this.estadoPedido = estadoPedido;
        this.idObra = idObra;
    }

    public EmpleadoDTO getEmpleadoDTO() {
        return empleadoDTO;
    }

    public void setEmpleadoDTO(EmpleadoDTO empleadoDTO) {
        this.empleadoDTO = empleadoDTO;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Instant getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Instant fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Integer getIdObra() {
        return idObra;
    }

    public void setIdObra(Integer idObra) {
        this.idObra = idObra;
    }
}