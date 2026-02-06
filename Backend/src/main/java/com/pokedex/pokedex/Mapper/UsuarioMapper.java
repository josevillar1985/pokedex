package com.pokedex.pokedex.Mapper;

import com.pokedex.pokedex.DTO.UsuarioDTO;
import com.pokedex.pokedex.Model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario dtoToUsuario(UsuarioDTO dto) {
        if (dto == null) return null;

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        return usuario;
    }

    public UsuarioDTO usuarioToDTO(Usuario usuario) {
        if (usuario == null) return null;

        return new UsuarioDTO(
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getPassword()
        );
    }
}
