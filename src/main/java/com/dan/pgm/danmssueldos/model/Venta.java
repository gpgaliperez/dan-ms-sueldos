package com.dan.pgm.danmssueldos.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double montoTotal;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLEADO_ID")
    private Empleado empleado;
    private Instant fechaVenta;


    public Venta(Integer id, Double montoTotal, Empleado empleado, Instant fechaVenta) {
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Instant getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Instant fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}

