package com.catys.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catys.backend.model.Categoria;
import com.catys.backend.repository.CategoriaRepository;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired 
    private CategoriaRepository categoriaRepo;

    // Solo debe haber UN método para @PostMapping("/api/categorias")
    @PostMapping
    public Categoria guardar(@RequestBody Categoria categoria) {
        return categoriaRepo.save(categoria);
    }

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        categoriaRepo.deleteById(id);
    }
}