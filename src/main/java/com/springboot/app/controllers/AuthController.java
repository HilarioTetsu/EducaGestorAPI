package com.springboot.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	
	@GetMapping("/")
    public ResponseEntity<String> authenticate() {
        // Lógica de autenticación aquí

        // Puedes devolver un mensaje personalizado o cualquier otra información
        String message = "Autenticación exitosa";
        return ResponseEntity.ok(message);
    }
}
