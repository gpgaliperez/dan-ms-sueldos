package com.dan.pgm.danmssueldos.dto;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class PedidoDTO {
    private Integer id;
    private Instant fechaPedido;
    private Integer idObra;
    private List<DetallePedidoDTO> detalle;
    private String estado;

    public PedidoDTO(Integer id, Instant fechaPedido, Integer idObra, List<DetallePedidoDTO> detalle, String estado) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.idObra = idObra;
        this.detalle = detalle;
        this.estado = estado;
    }

    public PedidoDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Instant fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Integer getIdObra() {
        return idObra;
    }

    public void setIdObra(Integer idObra) {
        this.idObra = idObra;
    }

    public List<DetallePedidoDTO> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetallePedidoDTO> detalle) {
        this.detalle = detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
