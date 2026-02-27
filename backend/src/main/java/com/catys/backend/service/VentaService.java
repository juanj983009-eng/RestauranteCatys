package com.catys.backend.service;

import com.catys.backend.model.Producto;
import com.catys.backend.model.Venta;
import com.catys.backend.repository.ProductoRepository;
import com.catys.backend.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
public class VentaService {
    @Autowired private VentaRepository ventaRepo;
    @Autowired private ProductoRepository productoRepo;

    @Transactional
    public Venta procesarVenta(Venta v) {
        Producto p = productoRepo.findById(v.getProducto().getId_producto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        if (p.getStock() < v.getCantidad()) throw new RuntimeException("Stock insuficiente");

        p.setStock(p.getStock() - v.getCantidad());
        productoRepo.save(p);

        v.setTotal(p.getPrecio() * v.getCantidad());
        v.setFecha(LocalDateTime.now());
        v.setProducto(p); // Aseguramos el objeto completo para el ticket
        
        return ventaRepo.save(v);
    }
}