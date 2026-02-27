package com.catys.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catys.backend.model.Producto;
import com.catys.backend.repository.ProductoRepository;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // Permite la conexión con el frontend
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepo;

    // Obtener todos los productos con su categoría
    @GetMapping
    public List<Producto> listarProductos() {
        return productoRepo.findAll();
    }

    // Guardar un nuevo producto o actualizar
    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        try {
            System.out.println("Intentando registrar producto: " + producto.getNombre());
            Producto nuevo = productoRepo.save(producto);
            return ResponseEntity.ok(nuevo);
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    // Eliminar producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) {
        if (productoRepo.existsById(id)) {
            productoRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}