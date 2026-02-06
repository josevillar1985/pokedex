package com.pokedex.pokedex.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.pokedex.pokedex.DTO.PokemonDTO;
import com.pokedex.pokedex.Mapper.PokemonMapper;
import com.pokedex.pokedex.Model.Pokemon;
import com.pokedex.pokedex.Repository.PokemonRepository;

@Service
public class PokemonService {

    private PokemonRepository repo;
    private PokemonMapper mapper;
    
    public PokemonService(PokemonRepository repo, PokemonMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<PokemonDTO> getAllPokemons() {
        return repo.findAll().stream().map(mapper::pokemonToPokemonDTO).toList();
    }

    public PokemonDTO addPokemon(PokemonDTO dto) {

        System.out.println("DTO RECIBIDO:");
        System.out.println("numero: " + dto.getNumero());
        System.out.println("nombre: " + dto.getNombre());
        System.out.println("tipo: " + dto.getTipo());
        System.out.println("hp: " + dto.getHp());
        System.out.println("ataque: " + dto.getAtaque());
        System.out.println("defensa: " + dto.getDefensa());
        System.out.println("imagen: " + dto.getImagen());

        Pokemon pokemon = mapper.pokemonDTOToPokemon(dto);
        Pokemon guardado = repo.save(pokemon);

     return mapper.pokemonToPokemonDTO(guardado);
    }

    public PokemonDTO getPokemonById(Long id){
        Pokemon pokemon = repo.findById(id).orElseThrow(() -> new RuntimeException("Pokemon no econrtado con id: " + id) );
        return mapper.pokemonToPokemonDTO(pokemon);
    }

    public  PokemonDTO updatePokemonById(Long id, PokemonDTO dto){
        Pokemon pokemon = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokemon no encontrado con id: " + id));
        pokemon.setNumero(dto.getNumero());
        pokemon.setNombre(dto.getNombre());
        pokemon.setTipo(dto.getTipo());
        pokemon.setHp(dto.getHp());
        pokemon.setAtaque(dto.getAtaque());
        pokemon.setDefensa(dto.getDefensa());
        pokemon.setImagen(dto.getImagen());

        Pokemon actualizado = repo.save(pokemon);
        return mapper.pokemonToPokemonDTO(actualizado);
    }

    public void deletePokemonById(Long id){
        repo.deleteById(id);
    }
}
