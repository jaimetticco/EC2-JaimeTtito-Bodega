package com.example.ec2jaimettitobodega.services;

import com.example.ec2jaimettitobodega.dto.request.ProductoDTOrequest;
import com.example.ec2jaimettitobodega.dto.response.ProductoDTOresponse;

import java.util.List;

public interface ProductosService {

    void guardar(ProductoDTOrequest productoDTOrequest);
    void actualizar(ProductoDTOrequest productoDTOrequest);
    void eliminar(Integer id);
    List<ProductoDTOresponse> listar();
    ProductoDTOresponse obtenerPorId(Integer id);
}
