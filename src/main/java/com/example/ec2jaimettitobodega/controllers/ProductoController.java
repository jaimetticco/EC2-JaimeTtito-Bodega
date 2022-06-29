package com.example.ec2jaimettitobodega.controllers;

import com.example.ec2jaimettitobodega.dto.request.ProductoDTOrequest;
import com.example.ec2jaimettitobodega.dto.response.ProductoDTOresponse;
import com.example.ec2jaimettitobodega.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/producto/v1")
public class ProductoController {

    @Autowired
    private ProductosService service;

    @RequestMapping("/listar")
    public @ResponseBody
    ResponseEntity<List<ProductoDTOresponse>> listar() {

        return new ResponseEntity<List<ProductoDTOresponse>>(service.listar(), HttpStatus.OK) ;
    }

    @RequestMapping( path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody ProductoDTOrequest producto) {
        service.guardar(producto);
        return  new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    @RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        ProductoDTOresponse p =service.obtenerPorId(id);
        if(p != null) {
            service.eliminar(id);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody ProductoDTOrequest producto) {
        ProductoDTOresponse p =service.obtenerPorId(producto.getId_pro());
        if(p != null) {
            service.actualizar(producto);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductoDTOresponse> obtenerId(@PathVariable Integer id) {
        ProductoDTOresponse p =service.obtenerPorId(id);
        if(p != null) {
            return  new ResponseEntity<ProductoDTOresponse>(service.obtenerPorId(id),HttpStatus.OK);
        }
        return  new ResponseEntity<ProductoDTOresponse>(HttpStatus.NOT_FOUND);
    }

}
