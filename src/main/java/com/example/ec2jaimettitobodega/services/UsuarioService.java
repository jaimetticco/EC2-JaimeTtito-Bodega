package com.example.ec2jaimettitobodega.services;

import com.example.ec2jaimettitobodega.dto.request.ProductoDTOrequest;
import com.example.ec2jaimettitobodega.dto.request.UsuarioDTOrequest;
import com.example.ec2jaimettitobodega.dto.response.ProductoDTOresponse;
import com.example.ec2jaimettitobodega.dto.response.UsuarioDTOresponse;

import java.util.List;

public interface UsuarioService {

    void guardar(UsuarioDTOrequest usuarioDTOrequest);
    void actualizar(UsuarioDTOrequest usuarioDTOrequest);
    void eliminar(Integer id);
    List<UsuarioDTOresponse> listar();
    UsuarioDTOresponse obtenerPorId(Integer id);
}
