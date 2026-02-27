package com.catys.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catys.backend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Método especial para buscar por nombre de usuario
    Optional<Usuario> findByUsername(String username);
}