package com.servientrega.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.servientrega.app.entity.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
}
