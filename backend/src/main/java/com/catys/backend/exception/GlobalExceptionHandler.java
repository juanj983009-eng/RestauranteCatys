package com.catys.backend.exception; // <--- Asegúrate que este paquete coincida con la ruta de tu carpeta

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Esto le dice a Spring que esta clase vigila a todos los controladores
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class) // Aquí atrapamos errores como "Stock insuficiente"
    public ResponseEntity<String> manejarError(RuntimeException e) {
        // En lugar de un error 500 feo, enviamos un mensaje claro al frontend
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}