package com.example.ec2jaimettitobodega.repository;

import com.example.ec2jaimettitobodega.model.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer> {
}
