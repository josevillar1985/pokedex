<template>
  <div class="editar-poke">
    <h2>Editar Pokémon</h2>

    <form @submit.prevent="guardar">
      <input
        type="text"
        v-model="pokemonEditado.nombre"
        placeholder="Nombre"
      />

      <input
        type="text"
        v-model="pokemonEditado.tipo"
        placeholder="Tipo"
      />

      <input
        type="number"
        v-model.number="pokemonEditado.hp"
        placeholder="HP"
      />

      <input
        type="number"
        v-model.number="pokemonEditado.ataque"
        placeholder="Ataque"
      />

      <input
        type="number"
        v-model.number="pokemonEditado.defensa"
        placeholder="Defensa"
      />

      <!-- IMAGEN -->
      <div class="imagen-upload">
        <label class="upload-btn">
          Subir imagen
          <input type="file" accept="image/*" @change="cargarImagen" />
        </label>

        <img v-if="preview" :src="preview" alt="Preview" class="preview" />
      </div>

      <!-- BOTONES -->
      <div class="acciones">
        <button type="submit">Guardar</button>
        <button type="button" @click="$emit('cerrar')">
          Cancelar
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import Swal from "sweetalert2";
import axios from "axios";

// 🔥 API HTTPS PRODUCCIÓN
const API_URL = "https://api.josevillar.com/api/pokemon";

export default {
  name: "EditarPoke",
  props: {
    pokemon: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      // 🧠 COPIA DEL PROP (nunca modificar props directamente)
      pokemonEditado: { ...this.pokemon },
      preview: this.pokemon.imagen || null
    };
  },
  methods: {
    cargarImagen(event) {
      const file = event.target.files[0];
      if (!file) return;

      const reader = new FileReader();
      reader.onload = () => {
        this.preview = reader.result;
        this.pokemonEditado.imagen = reader.result;
      };
      reader.readAsDataURL(file);
    },

    guardar() {
      axios
        .put(
          `${API_URL}/${this.pokemonEditado.id}`,
          this.pokemonEditado
        )
        .then(() => {
          Swal.fire({
            icon: "success",
            title: "¡Pokémon actualizado!",
            text: "Los datos se han guardado correctamente",
            background: "#1e1e1e",
            color: "#ffffff",
            iconColor: "#4caf50",
            timer: 1600,
            showConfirmButton: false
          });

          // 🔔 avisa al padre para recargar
          this.$emit("actualizado");
        })
        .catch(error => {
          Swal.fire({
            icon: "error",
            title: "Error al actualizar",
            text: "No se pudo guardar el Pokémon",
            background: "#1e1e1e",
            color: "#ffffff",
            iconColor: "#ef5350",
            confirmButtonColor: "#ef5350",
            confirmButtonText: "Cerrar"
          });

          console.error("❌ ERROR PUT", error);
        });
    }
  }
};
</script>

<style scoped>
.editar-poke {
  width: 100%;
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.editar-poke h2 {
  font-size: 16px;
  text-align: center;
  margin-bottom: 6px;
  color: #ffeb3b;
}

.editar-poke form {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.editar-poke input {
  width: 100%;
  padding: 7px 10px;
  border-radius: 8px;
  border: none;
  font-size: 13px;
  background: #2c2c2c;
  color: #ffffff;
  outline: none;
}

.editar-poke input::placeholder {
  color: #9e9e9e;
}

.editar-poke input:focus {
  box-shadow: 0 0 0 2px #ff1c1c;
}

.imagen-upload {
  display: flex;
  flex-direction: column;
  gap: 8px;
  align-items: center;
}

.upload-btn {
  background: linear-gradient(145deg, #7e57c2, #512da8);
  color: #fff;
  padding: 6px 12px;
  border-radius: 10px;
  font-size: 13px;
  cursor: pointer;
  font-weight: 600;
}

.upload-btn input {
  display: none;
}

.preview {
  width: 80px;
  height: 80px;
  object-fit: contain;
  border-radius: 8px;
  background: #2c2c2c;
  padding: 6px;
}

.editar-poke .acciones {
  display: flex;
  justify-content: space-between;
  margin-top: 10px;
}

.editar-poke button {
  padding: 7px 12px;
  border-radius: 9px;
  border: none;
  font-size: 13px;
  font-weight: 600;
  cursor: pointer;
}

.editar-poke button[type="submit"] {
  background: linear-gradient(145deg, #42a5f5, #1e88e5);
  color: #fff;
}

.editar-poke button[type="button"] {
  background: linear-gradient(145deg, #ef5350, #c62828);
  color: #fff;
}
</style>
