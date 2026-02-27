package com.catys.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catys.backend.model.Usuario;
import com.catys.backend.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepo;

    // Instanciamos el codificador de contraseñas
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public String login(@RequestBody Usuario loginData) {
        // 1. Buscamos al usuario por su nombre de usuario
        Optional<Usuario> userOpt = usuarioRepo.findByUsername(loginData.getUsername());

        if (userOpt.isPresent()) {
            Usuario user = userOpt.get();

            // 2. Comparamos la contraseña recibida (texto plano)
            // con la guardada en la BD (que ahora estará encriptada)
            if (encoder.matches(loginData.getPassword(), user.getPassword())) {
                return "OK";
            }
        }

        // 3. Si no existe o no coincide, lanzamos error
        throw new RuntimeException("Credenciales incorrectas");
    }

    // MÉTODO EXTRA: Úsalo una vez para generar tu clave encriptada y pegarla en SQL
    @GetMapping("/generar-clave/{rawPassword}")
    public String generarClave(@PathVariable String rawPassword) {
        return encoder.encode(rawPassword);
    }
}