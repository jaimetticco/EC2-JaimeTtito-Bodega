package com.example.ec2jaimettitobodega.services;

import com.example.ec2jaimettitobodega.dto.request.BodegaDTOrequest;
import com.example.ec2jaimettitobodega.dto.response.BodegaDTOresponse;

import java.util.List;

public interface BodegaService {

    void guardar(BodegaDTOrequest bodegaDTOrequest);
    void actualizar(BodegaDTOrequest bodegaDTOrequest);
    void eliminar(Integer id);
    List<BodegaDTOresponse> listar();
    BodegaDTOresponse obtenerPorId(Integer id);

}
