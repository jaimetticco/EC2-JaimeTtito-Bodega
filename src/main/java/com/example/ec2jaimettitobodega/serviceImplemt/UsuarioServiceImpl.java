package com.example.ec2jaimettitobodega.serviceImplemt;

import com.example.ec2jaimettitobodega.dto.request.UsuarioDTOrequest;
import com.example.ec2jaimettitobodega.dto.response.UsuarioDTOresponse;
import com.example.ec2jaimettitobodega.model.Usuario;
import com.example.ec2jaimettitobodega.repository.UsuarioRespository;
import com.example.ec2jaimettitobodega.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRespository respository;

    @Override
    public void guardar(UsuarioDTOrequest usuarioDTOrequest) {
        Usuario u = new Usuario();

        u.setUsuario(usuarioDTOrequest.getUsuario_bod());
        u.setPassword(usuarioDTOrequest.getPassword_usu());
        u.setRol(usuarioDTOrequest.getRol_usu());
        respository.save(u);

    }

    @Override
    public void actualizar(UsuarioDTOrequest usuarioDTOrequest) {
        Usuario u = new Usuario();

        u.setUsuario(usuarioDTOrequest.getUsuario_bod());
        u.setPassword(usuarioDTOrequest.getPassword_usu());
        u.setRol(usuarioDTOrequest.getRol_usu());

        respository.saveAndFlush(u);
    }

    @Override
    public void eliminar(Integer id) {
        respository.deleteById(id);
    }

    @Override
    public List<UsuarioDTOresponse> listar() {
        List<UsuarioDTOresponse> listar = new ArrayList<>();

        UsuarioDTOresponse dto = null;

        List<Usuario> u = respository.findAll();

        for (Usuario usuario: u) {

            dto = new UsuarioDTOresponse();

            dto.setUsuario_bod(usuario.getUsuario());
            dto.setPassword_usu(usuario.getPassword());
            dto.setRol_usu(usuario.getRol());

            listar.add(dto);
        }

        return listar;
    }

    @Override
    public UsuarioDTOresponse obtenerPorId(Integer id) {
        Usuario usuario = respository.findById(id).orElse(null);
        UsuarioDTOresponse dto = new UsuarioDTOresponse();

        dto.setUsuario_bod(usuario.getUsuario());
        dto.setPassword_usu(usuario.getPassword());
        dto.setRol_usu(usuario.getRol());

        return dto;
    }
}
