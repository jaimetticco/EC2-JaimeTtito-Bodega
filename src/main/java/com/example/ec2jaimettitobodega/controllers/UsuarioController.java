package com.example.ec2jaimettitobodega.controllers;


import com.example.ec2jaimettitobodega.dto.request.UsuarioDTOrequest;
import com.example.ec2jaimettitobodega.dto.response.UsuarioDTOresponse;
import com.example.ec2jaimettitobodega.security.JWTUtil;
import com.example.ec2jaimettitobodega.security.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private JWTUtil util;

    @Autowired
    private UserDetailService service;


    @RequestMapping(path = "/crearToken", method = RequestMethod.POST)
    public ResponseEntity<?> crearToken(@RequestBody UsuarioDTOrequest request){

        UserDetails user = service.loadUserByUsername(request.getUsuario_bod());
        return ResponseEntity.ok(new UsuarioDTOresponse(util.generateToken(user.getUsername())));

    }
}
