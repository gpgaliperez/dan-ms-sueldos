package com.dan.pgm.danmssueldos.dto;

public class EmpleadoDTO {

    private Integer id;
    private String nombre;
    private String mail;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(Integer id, String nombre, String mail) {
        this.id = id;
        this.nombre = nombre;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

