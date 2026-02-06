<template>
  <div class="pokemon-card">
    <div class="card-inner">
      <!-- CARA FRONTAL -->
      <div class="card-front" :class="pokemon.tipo">
        <span class="pokemon-number">{{ pokemon.numero }}</span>

        <img :src="pokemon.imagen" :alt="pokemon.nombre" />

        <h3>{{ pokemon.nombre }}</h3>

        <span class="type" :class="pokemon.tipo">
          {{ tipoLabel }}
        </span>
      </div>

      <!-- CARA TRASERA -->
      <div class="card-back">
        <h3>{{ pokemon.nombre }}</h3>
        <p><strong>HP:</strong> {{ pokemon.hp }}</p>
        <p><strong>Ataque:</strong> {{ pokemon.ataque }}</p>
        <p><strong>Defensa:</strong> {{ pokemon.defensa }}</p>
        <div class="card-actions">
          <button @click="$emit('editar', pokemon)" class="btn editar">Editar</button>
          <button class="btn borrar" @click="$emit('borrar', pokemon)">Borrar</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "PokemonCard",
  props: {
    pokemon: {
      type: Object,
      required: true
    }
  },
  computed: {
    tipoLabel() {
      const tipos = {
        grass: "Planta",
        fire: "Fuego",
        water: "Agua",
        electric: "Eléctrico",
        ice: "Hielo",
        fighting: "Lucha",
        poison: "Veneno",
        ground: "Tierra",
        flying: "Volador",
        psychic: "Psíquico",
        bug: "Bicho",
        rock: "Roca",
        ghost: "Fantasma",
        dragon: "Dragón",
        normal: "Normal",
        dark: "Siniestro",
        steel: "Acero",
        fairy: "Hada"
      };
      return tipos[this.pokemon.tipo] || this.pokemon.tipo;
    }
  }
};
</script>

<style scoped>
.pokemon-card {
  perspective: 1000px;
  width: 190px;
}

.card-inner {
  position: relative;
  height: 260px;
  transform-style: preserve-3d;
  transition: transform 0.7s;
}

.pokemon-card:hover .card-inner {
  transform: rotateY(180deg);
  cursor: pointer;
}

.card-front,
.card-back {
  position: absolute;
  inset: 0;
  backface-visibility: hidden;
  border-radius: 15px;
  padding: 15px;
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.4);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.card-front {
  color: #fff;
}

.card-front img {
  width: 100px;
  height: 100px;
}

.pokemon-number {
  position: absolute;
  font-size: 70px;
  font-weight: 900;
  color: rgba(255, 255, 255, 0.15);
}

.type {
  margin-top: 10px;
  padding: 6px 14px;
  border-radius: 12px;
  font-weight: bold;
}

/* ===== TIPOS (EN INGLÉS PARA CSS) ===== */

.card-front.grass {
  background: linear-gradient(145deg, #3fa129, #2d7d1f);
}

.type.grass {
  background: #7ac74c;
}

.card-front.fire {
  background: linear-gradient(145deg, #ff9800, #c62828);
}

.type.fire {
  background: #ff7043;
}

.card-front.water {
  background: linear-gradient(145deg, #42a5f5, #1e88e5);
}

.type.water {
  background: #64b5f6;
}

.card-front.electric {
  background: linear-gradient(145deg, #ffeb3b, #fbc02d);
  color: #000;
}

.type.electric {
  background: #ffd600;
  color: #000;
}

.card-front.ice {
  background: linear-gradient(145deg, #81d4fa, #0288d1);
}

.type.ice {
  background: #4fc3f7;
}

.card-front.fighting {
  background: linear-gradient(145deg, #e53935, #8e0000);
}

.type.fighting {
  background: #e53935;
}

.card-front.poison {
  background: linear-gradient(145deg, #ab47bc, #6a1b9a);
}

.type.poison {
  background: #ab47bc;
}

.card-front.ground {
  background: linear-gradient(145deg, #d7ccc8, #8d6e63);
}

.type.ground {
  background: #a1887f;
}

.card-front.flying {
  background: linear-gradient(145deg, #90caf9, #42a5f5);
}

.type.flying {
  background: #81d4fa;
  color: #000;
}

.card-front.psychic {
  background: linear-gradient(145deg, #f06292, #ad1457);
}

.type.psychic {
  background: #f06292;
}

.card-front.bug {
  background: linear-gradient(145deg, #9ccc65, #558b2f);
}

.type.bug {
  background: #9ccc65;
}

.card-front.rock {
  background: linear-gradient(145deg, #a1887f, #5d4037);
}

.type.rock {
  background: #8d6e63;
}

.card-front.ghost {
  background: linear-gradient(145deg, #7e57c2, #311b92);
}

.type.ghost {
  background: #7e57c2;
}

.card-front.dragon {
  background: linear-gradient(145deg, #5c6bc0, #1a237e);
}

.type.dragon {
  background: #5c6bc0;
}

.card-front.normal {
  background: linear-gradient(145deg, #bdbdbd, #757575);
}

.type.normal {
  background: #bdbdbd;
  color: #000;
}

.card-front.dark {
  background: linear-gradient(145deg, #424242, #000);
}

.type.dark {
  background: #424242;
}

.card-front.steel {
  background: linear-gradient(145deg, #b0bec5, #546e7a);
  color: #000;
}

.type.steel {
  background: #90a4ae;
  color: #000;
}

.card-front.fairy {
  background: linear-gradient(145deg, #f8bbd0, #f06292);
  color: #000;
}

.type.fairy {
  background: #f48fb1;
  color: #000;
}

.card-back {
  background: linear-gradient(145deg, #1e1e1e, #2c2c2c);
  color: #fff;
  transform: rotateY(180deg);
}

.card-actions {
  display: flex;
  gap: 10px;
  margin-top: 14px;
}

.btn {
  padding: 6px 12px;
  font-size: 13px;
  border-radius: 10px;
  border: none;
  cursor: pointer;
  font-weight: 600;
  transition: transform 0.2s, box-shadow 0.2s;
}

/* Botón editar */
.btn.editar {
  background: linear-gradient(145deg, #42a5f5, #1e88e5);
  color: #fff;
}

/* Botón borrar */
.btn.borrar {
  background: linear-gradient(145deg, #ef5350, #c62828);
  color: #fff;
}

/* Hover */
.btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
}

.card-actions {
  display: flex;
  gap: 10px;
  margin-top: 14px;
  margin-bottom: 25px; /* 👈 aquí */
}

</style>
