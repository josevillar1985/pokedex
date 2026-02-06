<template>
  <div>
    <HeaderComponent />

  <div class="form-pokedex">
    <form @submit.prevent="enviarFormulario">
      <h1>Registrar Pokémon</h1>

      <label>Nombre</label>
      <input type="text" v-model="pokemon.nombre" placeholder="Ej: Pikachu" />

      <label>Número Pokédex</label>
      <input type="text" v-model="pokemon.numero" placeholder="Ej: 004" />

      <label>Tipo</label>
      <select v-model="pokemon.tipo">
        <option disabled value="">Selecciona un tipo</option>
        <option v-for="tipo in tipos" :key="tipo.value" :value="tipo.value">
          {{ tipo.label }}
        </option>
      </select>

      <label>Ataque</label>
      <input type="number" v-model="pokemon.ataque" placeholder="Ej: 65" />

      <label>Defensa</label>
      <input type="number" v-model="pokemon.defensa" placeholder="Ej: 80" />

      <label>Vida</label>
      <input type="number" v-model="pokemon.hp" placeholder="Ej: 450" />

      
      <label>Imagen del Pokémon</label>
      <div class="file-wrapper">
        <input type="file" id="imagen" accept="image/*" @change="seleccionarImagen" />
        <label for="imagen" class="file-label">
          {{ imagenNombre || 'Seleccionar imagen' }}
        </label>
      </div>

      
      <div v-if="imagenPreview" class="preview">
        <img :src="imagenPreview" alt="Preview Pokémon" />
      </div>

      <button>Guardar Pokémon</button>
    </form>
  </div>

  </div>
  
</template>

<script>
import HeaderComponent from "./HeaderComponent.vue";
import axios from "axios";
import Swal from "sweetalert2";

export default {
  name: "FormPokemon",
  components: {
    HeaderComponent
  },
  data() {
    return {
      pokemon: {
        numero: "",
        nombre: "",
        tipo: "",
        ataque: "",
        defensa: "",
        hp: ""
      },

      tipos: [
        { value: "grass", label: "Planta" },
        { value: "fire", label: "Fuego" },
        { value: "water", label: "Agua" },
        { value: "electric", label: "Eléctrico" },
        { value: "ice", label: "Hielo" },
        { value: "fighting", label: "Lucha" },
        { value: "poison", label: "Veneno" },
        { value: "ground", label: "Tierra" },
        { value: "flying", label: "Volador" },
        { value: "psychic", label: "Psíquico" },
        { value: "bug", label: "Bicho" },
        { value: "rock", label: "Roca" },
        { value: "ghost", label: "Fantasma" },
        { value: "dragon", label: "Dragón" },
        { value: "normal", label: "Normal" },
        { value: "dark", label: "Siniestro" },
        { value: "steel", label: "Acero" },
        { value: "fairy", label: "Hada" }
      ],

      imagenPreview: null,
      imagenNombre: ""
    };
  },

  methods: {
    seleccionarImagen(event) {
      const file = event.target.files[0];
      if (!file) return;

      this.imagenNombre = file.name;

      const reader = new FileReader();
      reader.onload = e => {
        this.imagenPreview = e.target.result;
      };
      reader.readAsDataURL(file);
    },

    enviarFormulario() {
      if (
        !this.pokemon.nombre ||
        !this.pokemon.numero ||
        !this.pokemon.tipo ||
        !this.pokemon.ataque ||
        !this.pokemon.defensa ||
        !this.pokemon.hp
      ) {
        return Swal.fire({
          icon: "error",
          title: "Campos obligatorios",
          text: "Rellena todos los campos"
        });
      }

      axios
        .post("/api/pokemon", {
          numero: this.pokemon.numero,
          nombre: this.pokemon.nombre,
          tipo: this.pokemon.tipo,
          hp: this.pokemon.hp,
          ataque: this.pokemon.ataque,
          defensa: this.pokemon.defensa,
          imagen: this.imagenPreview
        })
        .then(() => {
          Swal.fire({
            icon: "success",
            title: "¡Pokémon registrado!"
          });

          this.pokemon = {
            numero: "",
            nombre: "",
            tipo: "",
            ataque: "",
            defensa: "",
            hp: ""
          };
          this.imagenPreview = null;
          this.imagenNombre = "";
        })
        .catch(err => {
          console.error(err);
          Swal.fire({
            icon: "error",
            title: "Error",
            text: "No se pudo guardar el Pokémon"
          });
        });
    }
  }
};
</script>


<style scoped>
.form-pokedex {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.form-pokedex form {
  background: linear-gradient(135deg, #c62828, #8e0000);
  border-radius: 12px;
  padding: 28px;
  width: 420px;
}

label {
  display: block;
  margin-top: 14px;
  color: #fff;
}

input,
select {
  width: 100%;
  padding: 8px;
  margin-top: 6px;
}

.file-wrapper input {
  display: none;
}

.file-label {
  display: block;
  margin-top: 6px;
  padding: 10px;
  background: #111;
  color: #ffeb3b;
  text-align: center;
  cursor: pointer;
}

.preview {
  margin-top: 14px;
  text-align: center;
}

.preview img {
  max-width: 200px;
}

button {
  width: 100%;
  margin-top: 20px;
  padding: 10px;
  font-weight: bold;
}
</style>
