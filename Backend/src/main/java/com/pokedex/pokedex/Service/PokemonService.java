package com.pokedex.pokedex.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.pokedex.pokedex.DTO.PokemonDTO;
import com.pokedex.pokedex.Mapper.PokemonMapper;
import com.pokedex.pokedex.Model.Pokemon;
import com.pokedex.pokedex.Repository.PokemonRepository;

@Service
public class PokemonService {

    private final PokemonRepository repo;
    private final PokemonMapper mapper;

    public PokemonService(PokemonRepository repo, PokemonMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<PokemonDTO> getAllPokemons() {
        return repo.findAll().stream().map(mapper::pokemonToPokemonDTO).toList();
    }

    public PokemonDTO addPokemon(PokemonDTO dto) {
        Pokemon pokemon = mapper.pokemonDTOToPokemon(dto);
        Pokemon guardado = repo.save(pokemon);
        return mapper.pokemonToPokemonDTO(guardado);
    }

    public PokemonDTO getPokemonById(Long id){
        Pokemon pokemon = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokemon no encontrado con id: " + id));
        return mapper.pokemonToPokemonDTO(pokemon);
    }

    public PokemonDTO updatePokemonById(Long id, PokemonDTO dto){
        // Verificamos existencia antes de intentar actualizar
        if (!repo.existsById(id)) {
            throw new RuntimeException("Pokemon no encontrado con id: " + id);
        }

        // Forzamos que la entidad tenga el ID de la URL
        dto.setId(id);
        Pokemon pokemon = mapper.pokemonDTOToPokemon(dto);

        // Al tener ID, save() actúa como un Update
        Pokemon actualizado = repo.save(pokemon);
        return mapper.pokemonToPokemonDTO(actualizado);
    }

    public void deletePokemonById(Long id){
        repo.deleteById(id);
    }
}