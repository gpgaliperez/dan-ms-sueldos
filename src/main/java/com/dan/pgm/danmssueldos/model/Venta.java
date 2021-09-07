package com.dan.pgm.danmssueldos.model;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double montoTotal;
    private Integer empleado;
    private LocalDate fechaVenta;


    public Venta(Integer id, Double montoTotal, Integer empleado, LocalDate fechaVenta) {
        this.id = id;
        this.montoTotal = montoTotal;
        this.empleado = empleado;
        this.fechaVenta = fechaVenta;
    }

    public Venta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Integer getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Integer empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}

