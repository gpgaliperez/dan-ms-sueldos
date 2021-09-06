package com.dan.pgm.danmssueldos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReciboSueldo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idRecibo;
    private Double montoTotal;
    private Integer empleadoId;

    public ReciboSueldo(Double montoTotal, Integer empleadoId) {

        this.montoTotal = montoTotal;
        this.empleadoId = empleadoId;
    }

    public ReciboSueldo() {

    }

    public Integer getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(Integer idRecibo) {
        this.idRecibo = idRecibo;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }
}
