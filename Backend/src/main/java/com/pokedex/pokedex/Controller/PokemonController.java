package com.pokedex.pokedex.Controller;
import org.springframework.web.bind.annotation.*;
import com.pokedex.pokedex.DTO.PokemonDTO;
import com.pokedex.pokedex.Service.PokemonService;

import java.util.List;


@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<PokemonDTO> getAllPokemons() {

        return pokemonService.getAllPokemons();
    }
    @PostMapping
    public PokemonDTO createPokemon(@RequestBody PokemonDTO dto) {
        return pokemonService.addPokemon(dto);
    }
    @GetMapping("/{id}")
    public PokemonDTO getPokemonById (@PathVariable Long id){
        return pokemonService.getPokemonById(id);
    }

    @PutMapping("/{id}")
    public PokemonDTO updatePokemonById(@PathVariable Long id, @RequestBody PokemonDTO dto) {
        return pokemonService.updatePokemonById(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable Long id) {
        pokemonService.deletePokemonById(id);
    }

}
