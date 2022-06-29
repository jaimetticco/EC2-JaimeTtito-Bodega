package com.example.ec2jaimettitobodega.repository;

import com.example.ec2jaimettitobodega.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
