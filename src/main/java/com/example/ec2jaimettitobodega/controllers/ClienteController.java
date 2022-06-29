package com.example.ec2jaimettitobodega.controllers;

import com.example.ec2jaimettitobodega.dto.request.ClienteDTOrequest;
import com.example.ec2jaimettitobodega.dto.response.ClienteDTOresponse;
import com.example.ec2jaimettitobodega.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cliente/v1")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @RequestMapping("/listar")
    public @ResponseBody
    ResponseEntity<List<ClienteDTOresponse>> listar() {

        return new ResponseEntity<List<ClienteDTOresponse>>(service.listar(), HttpStatus.OK) ;
    }

    @RequestMapping( path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody ClienteDTOrequest request) {
        service.guardar(request);
        return  new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    @RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        ClienteDTOresponse c =service.obtenerPorId(id);
        if(c != null) {
            service.eliminar(id);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody ClienteDTOrequest request) {
        ClienteDTOresponse c =service.obtenerPorId(request.getId_cli());
        if(c != null) {
            service.actualizar(request);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClienteDTOresponse> obtenerId(@PathVariable Integer id) {
        ClienteDTOresponse c =service.obtenerPorId(id);
        if(c != null) {
            return  new ResponseEntity<ClienteDTOresponse>(service.obtenerPorId(id),HttpStatus.OK);
        }
        return  new ResponseEntity<ClienteDTOresponse>(HttpStatus.NOT_FOUND);
    }


}
