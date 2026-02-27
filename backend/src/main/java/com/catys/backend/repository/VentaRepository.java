package com.catys.backend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catys.backend.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
    // Este nombre debe ser exacto para que Spring Boot cree la consulta SQL sola
    List<Venta> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);
}