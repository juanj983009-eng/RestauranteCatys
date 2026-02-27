package com.catys.backend.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.catys.backend.model.Venta;
import com.catys.backend.repository.VentaRepository;
import com.catys.backend.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*") // Crucial para la conexión con el frontend
public class VentaController {

    // Ahora inyectamos el Service, no el Repository directamente
    @Autowired
    private VentaService ventaService;

    @Autowired
    private VentaRepository ventaRepo;

    // 1. FILTRADO PARA EL GRÁFICO (Cierre de Caja)
    @GetMapping("/filtro")
    public List<Venta> filtrarVentas(@RequestParam String fecha) {
        LocalDate date = LocalDate.parse(fecha);
        return ventaRepo.findByFechaBetween(date.atStartOfDay(), date.atTime(23, 59, 59));
    }

    // 2. REGISTRO DE VENTA (DELEGADO AL SERVICE)
    // El @ControllerAdvice que creamos en el paso anterior
    // se encargará de capturar cualquier error (como "Stock insuficiente")
    @PostMapping
    public Venta registrarVenta(@RequestBody Venta venta) {
        return ventaService.procesarVenta(venta);
    }

    // 3. LISTAR TODAS (HISTÓRICO)
    @GetMapping
    public List<Venta> listarTodas() {
        return ventaRepo.findAll();
    }
}