package com.dan.pgm.danmssueldos.dto;

public class DetallePedidoDTO {

    private Integer id;
    private Integer idProducto;
    private Integer cantidad;
    private Double precio;

    public DetallePedidoDTO(){}

    public DetallePedidoDTO(Integer id, Integer idProducto, Integer cantidad, Double precio) {
        this.id = id;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
