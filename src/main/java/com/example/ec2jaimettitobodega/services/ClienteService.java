package com.example.ec2jaimettitobodega.services;

import com.example.ec2jaimettitobodega.dto.request.ClienteDTOrequest;
import com.example.ec2jaimettitobodega.dto.response.ClienteDTOresponse;

import java.util.List;

public interface ClienteService {

    void guardar(ClienteDTOrequest clienteDTOrequest);
    void actualizar(ClienteDTOrequest clienteDTOrequest);
    void eliminar(Integer id);
    List<ClienteDTOresponse> listar();
    ClienteDTOresponse obtenerPorId(Integer id);
}
