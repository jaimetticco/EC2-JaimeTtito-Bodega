package com.example.ec2jaimettitobodega.serviceImplemt;

import com.example.ec2jaimettitobodega.dto.request.BodegaDTOrequest;
import com.example.ec2jaimettitobodega.dto.response.BodegaDTOresponse;
import com.example.ec2jaimettitobodega.model.Bodega;
import com.example.ec2jaimettitobodega.repository.BodegaRepository;
import com.example.ec2jaimettitobodega.services.BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BodegaServiceImpl implements BodegaService {

    @Autowired
    private BodegaRepository repository;


    @Override
    public void guardar(BodegaDTOrequest bodegaDTOrequest) {

        Bodega b = new Bodega();
        b.setNombre(bodegaDTOrequest.getNombre_bod());
        b.setDireccion(bodegaDTOrequest.getDireccion_dob());
        b.setProducto(bodegaDTOrequest.getProductos());
        repository.save(b);
    }

    @Override
    public void actualizar(BodegaDTOrequest bodegaDTOrequest) {
        Bodega b = new Bodega();
        b.setId_bodega(bodegaDTOrequest.getId_bod());
        b.setNombre(bodegaDTOrequest.getNombre_bod());
        b.setDireccion(bodegaDTOrequest.getDireccion_dob());
        b.setProducto(bodegaDTOrequest.getProductos());
        repository.saveAndFlush(b);

    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<BodegaDTOresponse> listar() {

        List<BodegaDTOresponse> listar = new ArrayList<>();
        BodegaDTOresponse dto = null;
        List<Bodega> b = repository.findAll();

        for (Bodega bodega: b) {
            dto = new BodegaDTOresponse();

            dto.setNombre_bod(bodega.getNombre());
            dto.setDireccion_dob(bodega.getDireccion());
            dto.setProductos(bodega.getProducto());
            listar.add(dto);
        }
        return listar;
    }

    @Override
    public BodegaDTOresponse obtenerPorId(Integer id) {
        Bodega bodega = repository.findById(id).orElse(null);
        BodegaDTOresponse dto = new BodegaDTOresponse();

        dto.setId_bod(bodega.getId_bodega());
        dto.setNombre_bod(bodega.getNombre());
        dto.setDireccion_dob(bodega.getDireccion());

        return dto;
    }
}
