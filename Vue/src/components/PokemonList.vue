<template>
  <div>
    <HeaderComponent />

    <!-- BUSCADOR -->
    <div class="search-wrapper">
      <div class="search-box">
        <input type="text" v-model="busqueda" placeholder="Buscar Pokémon..." />
      </div>
    </div>

    <!-- LISTA -->
    <main class="pokemon-grid">
      <PokemonCard v-for="pokemon in pokemonsFiltrados" :key="pokemon.id" :pokemon="pokemon" @editar="abrirModal"
        @borrar="confirmarBorrado" />
    </main>

    <!-- MODAL -->
    <div v-if="mostrarModal" class="modal-overlay">
      <div class="modal">
        <EditarPoke :pokemon="pokemonSeleccionado" @cerrar="cerrarModal" @actualizado="pokemonActualizado" />
      </div>
    </div>
  </div>
</template>


<script>
import axios from "axios";
import Swal from "sweetalert2";
import PokemonCard from "./PokemonCard.vue";
import EditarPoke from "./EditarPoke.vue";
import HeaderComponent from "./HeaderComponent.vue";

export default {
  name: "PokemonList",
  components: {
    HeaderComponent,
    PokemonCard,
    EditarPoke
  },
  data() {
    return {
      pokemons: [],
      busqueda: "",
      mostrarModal: false,
      pokemonSeleccionado: null
    };
  },
  computed: {
    pokemonsFiltrados() {
      if (!this.busqueda) {
        return this.pokemons;
      }

      const texto = this.busqueda.toLowerCase();

      return this.pokemons.filter(pokemon =>
        pokemon.nombre.toLowerCase().includes(texto) ||
        pokemon.tipo.toLowerCase().includes(texto)
      );
    }
  },
  methods: {
    abrirModal(pokemon) {
      this.pokemonSeleccionado = pokemon;
      this.mostrarModal = true;
    },
    cerrarModal() {
      this.mostrarModal = false;
      this.pokemonSeleccionado = null;
    },
    pokemonActualizado() {
      this.cerrarModal();
      this.cargarPokemons();
    },
    cargarPokemons() {
      axios
        .get("http://localhost:8082/api/pokemon")
        .then(response => {
          this.pokemons = response.data;
        })
        .catch(error => {
          console.log("Error al cargar Pokémon", error);
        });
    },
    confirmarBorrado(pokemon) {
      Swal.fire({
        title: `¿Borrar a ${pokemon.nombre}?`,
        text: "Esta acción no se puede deshacer",
        icon: "warning",
        background: "#1e1e1e",
        color: "#ffffff",
        iconColor: "#ef5350",
        showCancelButton: true,
        confirmButtonColor: "#ef5350",
        cancelButtonColor: "#42a5f5",
        confirmButtonText: "Sí, borrar",
        cancelButtonText: "Cancelar"
      }).then(result => {
        if (result.isConfirmed) {
          this.borrarPokemon(pokemon);
        }
      });
    },
    borrarPokemon(pokemon) {
      axios
        .delete(`http://localhost:8082/api/pokemon/${pokemon.numero}`)
        .then(() => {
          Swal.fire({
            icon: "success",
            title: "Eliminado",
            text: `${pokemon.nombre} ha sido borrado`,
            background: "#1e1e1e",
            color: "#ffffff",
            iconColor: "#4caf50",
            timer: 1500,
            showConfirmButton: false
          });

          this.cargarPokemons();
        })
        .catch(error => {
          Swal.fire({
            icon: "error",
            title: "Error",
            text: "No se pudo borrar el Pokémon",
            background: "#1e1e1e",
            color: "#ffffff",
            iconColor: "#ef5350"
          });

          console.error("❌ ERROR DELETE", error);
        });
    }
  },
  mounted() {
    this.cargarPokemons();
  }
};
</script>

<style scoped>
/* ===== BUSCADOR ===== */
.search-wrapper {
  display: flex;
  justify-content: center;
  margin: 25px 0 15px;
}

.search-box {
  position: relative;
  width: 360px;
  max-width: 90%;
}

.search-box input {
  width: 100%;
  padding: 12px 18px;
  border-radius: 30px;
  border: none;
  font-size: 16px;
  background: #1e1e1e;
  color: #fff;
  outline: none;
}

/* ===== GRID ===== */
.pokemon-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  padding: 20px;
  gap: 20px;
}

/* ===== MODAL ===== */
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background: rgba(0, 0, 0, 0.6);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1000;
}

.modal {
  background: #1e1e1e;
  padding: 18px;
  border-radius: 12px;
  width: 300px;
  /* pequeño */
  max-width: 90%;
  color: #fff;
}
</style>
