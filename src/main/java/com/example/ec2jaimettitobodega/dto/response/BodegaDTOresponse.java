package com.example.ec2jaimettitobodega.dto.response;

import com.example.ec2jaimettitobodega.model.Productos;

public class BodegaDTOresponse {

    private Integer id_bod;
    private String nombre_bod;
    private String direccion_dob;
    private Productos productos;

    public Integer getId_bod() {
        return id_bod;
    }

    public void setId_bod(Integer id_bod) {
        this.id_bod = id_bod;
    }

    public String getNombre_bod() {
        return nombre_bod;
    }

    public void setNombre_bod(String nombre_bod) {
        this.nombre_bod = nombre_bod;
    }

    public String getDireccion_dob() {
        return direccion_dob;
    }

    public void setDireccion_dob(String direccion_dob) {
        this.direccion_dob = direccion_dob;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
}
