package com.pokedex.pokedex.Service;

import com.pokedex.pokedex.DTO.UsuarioDTO;
import com.pokedex.pokedex.Mapper.UsuarioMapper;
import com.pokedex.pokedex.Model.Usuario;
import com.pokedex.pokedex.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository repo, UsuarioMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public UsuarioDTO crearUsuario(UsuarioDTO dto) {
        Usuario usuario = mapper.dtoToUsuario(dto);
        Usuario guardado = repo.save(usuario);
        return mapper.usuarioToDTO(guardado);
    }

    public UsuarioDTO obtenerEmail(String email) {
        Usuario usuario = repo.findByEmail(email);
        return mapper.usuarioToDTO(usuario);
    }
}
