package com.pokedex.pokedex.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pokedex.pokedex.Model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
