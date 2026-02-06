package com.pokedex.pokedex.Controller;

import com.pokedex.pokedex.DTO.UsuarioDTO;
import com.pokedex.pokedex.Service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*") // Importante si vas a conectar un Frontend (React/Angular)
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioDTO dto) {
        // Usamos ResponseEntity para devolver un código 201 (Created)
        return ResponseEntity.status(201).body(service.crearUsuario(dto));
    }

    @GetMapping("/{email}")
    public ResponseEntity<UsuarioDTO> obtenerPorEmail(@PathVariable String email) {
        System.out.println("Buscando usuario con email: " + email);
        UsuarioDTO usuario = service.obtenerEmail(email);
        return ResponseEntity.ok(usuario);
    }
}