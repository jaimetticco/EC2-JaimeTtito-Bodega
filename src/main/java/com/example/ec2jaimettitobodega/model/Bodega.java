package com.example.ec2jaimettitobodega.model;

import javax.persistence.*;

@Entity
@Table(name = "bodega")
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_bodega;
    private String nombre;
    private String direccion;

    @OneToOne
    @JoinColumn(
            name = "id_producto",
            nullable = false,
            unique = true,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_producto) references Productos(id_producto)")
    )
    private Productos producto;

    public Integer getId_bodega() {
        return id_bodega;
    }

    public void setId_bodega(Integer id_bodega) {
        this.id_bodega = id_bodega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
}
