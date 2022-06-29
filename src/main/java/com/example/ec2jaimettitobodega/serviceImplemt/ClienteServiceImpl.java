package com.example.ec2jaimettitobodega.serviceImplemt;

import com.example.ec2jaimettitobodega.dto.request.ClienteDTOrequest;
import com.example.ec2jaimettitobodega.dto.response.ClienteDTOresponse;
import com.example.ec2jaimettitobodega.model.Cliente;
import com.example.ec2jaimettitobodega.repository.ClienteRepository;
import com.example.ec2jaimettitobodega.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public void guardar(ClienteDTOrequest clienteDTOrequest) {
        Cliente c = new Cliente();
        c.setNombre(clienteDTOrequest.getNombre_cli());
        c.setDireccion(clienteDTOrequest.getDireccion_cli());
        c.setDni(clienteDTOrequest.getDni_cli());
        repository.save(c);
    }

    @Override
    public void actualizar(ClienteDTOrequest clienteDTOrequest) {
        Cliente c = new Cliente();
        c.setNombre(clienteDTOrequest.getNombre_cli());
        c.setDireccion(clienteDTOrequest.getDireccion_cli());
        c.setDni(clienteDTOrequest.getDni_cli());
        repository.saveAndFlush(c);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<ClienteDTOresponse> listar() {

        List<ClienteDTOresponse> listar = new ArrayList<>();

        ClienteDTOresponse dto = null;

        List<Cliente> c = repository.findAll();

        for (Cliente cliente : c) {

            dto = new ClienteDTOresponse();

            dto.setNombre_cli(cliente.getNombre());
            dto.setDireccion_cli(cliente.getDireccion());
            dto.setDni_cli(cliente.getDni());

            listar.add(dto);
        }

        return listar;
    }

    @Override
    public ClienteDTOresponse obtenerPorId(Integer id) {
        Cliente cliente = repository.findById(id).orElse(null);
        ClienteDTOresponse dto = new ClienteDTOresponse();

        dto.setNombre_cli(cliente.getNombre());
        dto.setDireccion_cli(cliente.getDireccion());
        dto.setDni_cli(cliente.getDni());

        return dto;
    }
}
