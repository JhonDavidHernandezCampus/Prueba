package com.servientrega.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.servientrega.app.entity.Paquete;

public interface PaqueteRepository extends JpaRepository<Paquete, Long> {
}
