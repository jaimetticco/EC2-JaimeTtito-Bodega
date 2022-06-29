package com.example.ec2jaimettitobodega.repository;

import com.example.ec2jaimettitobodega.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRespository extends JpaRepository<Usuario, Integer> {
}
