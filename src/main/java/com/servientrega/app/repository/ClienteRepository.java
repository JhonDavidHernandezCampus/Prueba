package com.servientrega.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.servientrega.app.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}