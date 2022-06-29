package com.example.ec2jaimettitobodega.repository;

import com.example.ec2jaimettitobodega.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
}
