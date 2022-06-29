package com.example.ec2jaimettitobodega.controllers;

import com.example.ec2jaimettitobodega.dto.request.BodegaDTOrequest;
import com.example.ec2jaimettitobodega.dto.response.BodegaDTOresponse;
import com.example.ec2jaimettitobodega.services.BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/bodega/v1")
public class BodegaController {

    @Autowired
    private BodegaService service;

    @RequestMapping("/listar")
    public @ResponseBody
    ResponseEntity<List<BodegaDTOresponse>> listar() {

        return new ResponseEntity<List<BodegaDTOresponse>>(service.listar(), HttpStatus.OK) ;
    }

    @RequestMapping( path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody BodegaDTOrequest request) {
        service.guardar(request);
        return  new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    @RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        BodegaDTOresponse b =service.obtenerPorId(id);
        if(b != null) {
            service.eliminar(id);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody BodegaDTOrequest request) {
        BodegaDTOresponse b =service.obtenerPorId(request.getId_bod());
        if(b != null) {
            service.actualizar(request);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<BodegaDTOresponse> obtenerId(@PathVariable Integer id) {
        BodegaDTOresponse b =service.obtenerPorId(id);
        if(b != null) {
            return  new ResponseEntity<BodegaDTOresponse>(service.obtenerPorId(id),HttpStatus.OK);
        }
        return  new ResponseEntity<BodegaDTOresponse>(HttpStatus.NOT_FOUND);
    }




}
