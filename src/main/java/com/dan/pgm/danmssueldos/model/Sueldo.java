package com.dan.pgm.danmssueldos.model;

public class Sueldo {
    private Empleado empleado;
    private Double porcentajeBonificacion;

    public Sueldo(Empleado empleado, Double porcentajeBonificacion) {
        this.empleado = empleado;
        this.porcentajeBonificacion = porcentajeBonificacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Double getPorcentajeBonificacion() {
        return porcentajeBonificacion;
    }

    public void setPorcentajeBonificacion(Double porcentajeBonificacion) {
        this.porcentajeBonificacion = porcentajeBonificacion;
    }
}
