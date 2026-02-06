package com.pokedex.pokedex.Mapper;

import org.springframework.stereotype.Component;

import com.pokedex.pokedex.DTO.PokemonDTO;
import com.pokedex.pokedex.Model.Pokemon;

@Component
public class PokemonMapper {

    public PokemonDTO pokemonToPokemonDTO(Pokemon pokemon) {

    if (pokemon == null) {
        return null;
    }

    PokemonDTO dto = new PokemonDTO();
    dto.setNumero(pokemon.getNumero());
    dto.setNombre(pokemon.getNombre());
    dto.setTipo(pokemon.getTipo());
    dto.setHp(pokemon.getHp());
    dto.setAtaque(pokemon.getAtaque());
    dto.setDefensa(pokemon.getDefensa());
    dto.setImagen(pokemon.getImagen());
    return dto;
}

public Pokemon pokemonDTOToPokemon(PokemonDTO dto) {

    if (dto == null) {
        return null;
    }

    Pokemon pokemon = new Pokemon();
    pokemon.setNumero(dto.getNumero());
    pokemon.setNombre(dto.getNombre());
    pokemon.setTipo(dto.getTipo());
    pokemon.setHp(dto.getHp());
    pokemon.setAtaque(dto.getAtaque());
    pokemon.setDefensa(dto.getDefensa());
    pokemon.setImagen(dto.getImagen());
    return pokemon;
}

}
