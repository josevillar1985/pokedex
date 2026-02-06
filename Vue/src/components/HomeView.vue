<template>
  <div>
    <HeaderComponent />

    <main class="home">
      
      <section class="welcome">
        <h1>Bienvenido a tu Pokédex</h1>

        <p class="subtitle">
          Crea, gestiona y personaliza tus Pokémon favoritos.
          Todo a tu manera. Todo bajo control.
        </p>

        <div class="actions">
          <router-link to="/pokedex" class="btn primary">
            Ver Pokédex
          </router-link>

          <router-link to="/pokemon" class="btn secondary">
            Crear Pokémon
          </router-link>
        </div>
      </section>

      
      <section class="features">
  <div class="feature">
    <h3>📘 Pokédex personalizada</h3>
    <p>
      Añade, edita y elimina Pokémon creados por ti.
    </p>
  </div>

  <div class="feature">
    <h3>🔍 Búsqueda inteligente</h3>
    <p>
      Encuentra Pokémon fácilmente por nombre o tipo.
    </p>
  </div>

  <div class="feature">
    <h3>⚙️ Proyecto real</h3>
    <p>
      Vue + Spring Boot con estructura profesional.
    </p>
  </div>
</section>

    </main>
  </div>
</template>

<script>
import HeaderComponent from "@/components/HeaderComponent.vue";

export default {
  name: "HomeView",
  components: {
    HeaderComponent
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Orbitron:wght@400;600;800&display=swap');

.home {
  font-family: 'Orbitron', sans-serif;
  color: #ffe031;
}

/* BIENVENIDA */
.welcome {
  text-align: center;
  padding: 80px 20px 60px;
  background: radial-gradient(circle at top, #1f1f1f, #0b0b0b);
}

.welcome h1 {
  font-size: 42px;
  margin-bottom: 20px;
}

.subtitle {
  max-width: 600px;
  margin: auto;
  font-size: 16px;
  color: #ddd;
}

/* BOTONES */
.actions {
  margin-top: 30px;
  display: flex;
  justify-content: center;
  gap: 20px;
}

.btn {
  padding: 12px 24px;
  border-radius: 30px;
  text-decoration: none;
  font-weight: 600;
  transition: transform 0.2s ease, box-shadow 0.2s ease;
}

.btn.primary {
  background: #ffe031;
  color: #000;
}

.btn.secondary {
  border: 2px solid #ffe031;
  color: #ffe031;
}

.btn:hover {
  transform: translateY(-3px);
  box-shadow: 0 8px 20px rgba(255,224,49,0.4);
}

/* FEATURES */
.features {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
  gap: 30px;
  padding: 60px;
  background: #121212;
}

.feature {
  background: linear-gradient(135deg, #1e1e1e, #0f0f0f);
  padding: 30px;
  border-radius: 24px;
  box-shadow: 0 10px 25px rgba(0,0,0,0.6);
}

.feature h3 {
  margin-bottom: 12px;
}

.feature p {
  color: #ccc;
  font-size: 14px;
}
</style>
