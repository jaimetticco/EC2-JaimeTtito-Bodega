package com.example.ec2jaimettitobodega.dto.response;

public class ProductoDTOresponse {

    private Integer id_pro;
    private String name_producto;
    private String descripcion_pro;
    private Double precio_pro;
    private Integer stock_pro;


    public Integer getId_pro() {
        return id_pro;
    }

    public void setId_pro(Integer id_pro) {
        this.id_pro = id_pro;
    }

    public String getName_producto() {
        return name_producto;
    }

    public void setName_producto(String name_producto) {
        this.name_producto = name_producto;
    }

    public String getDescripcion_pro() {
        return descripcion_pro;
    }

    public void setDescripcion_pro(String descripcion_pro) {
        this.descripcion_pro = descripcion_pro;
    }

    public Double getPrecio_pro() {
        return precio_pro;
    }

    public void setPrecio_pro(Double precio_pro) {
        this.precio_pro = precio_pro;
    }

    public Integer getStock_pro() {
        return stock_pro;
    }

    public void setStock_pro(Integer stock_pro) {
        this.stock_pro = stock_pro;
    }
}
