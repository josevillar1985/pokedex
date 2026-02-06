package com.pokedex.pokedex.Controller;

import com.pokedex.pokedex.DTO.UsuarioDTO;
import com.pokedex.pokedex.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO dto) {
        return service.crearUsuario(dto);
    }

    @GetMapping("/{email:.+}")
    public UsuarioDTO obtenerEmail(@PathVariable String email) {
        System.out.println("EMAIL RECIBIDO: " + email);

        return service.obtenerEmail(email);
    }

}
