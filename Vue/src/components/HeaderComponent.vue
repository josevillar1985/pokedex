<template>
  <div class="header-wrapper">
    <header class="container-header">
      <img src="@/assets/pokedex.png" alt="Logo" class="logo" />
    </header>

    <nav class="nav-bar">
      <router-link to="/home" active-class="active">Inicio</router-link>
      <router-link to="/pokedex" active-class="active">Pokedex</router-link>
      <router-link to="/pokemon" active-class="active">Crear Pokémon</router-link>
    </nav>
  </div>
</template>

<script>
export default {
  name: "HeaderComponent"
}
</script>

<style scoped>
.header-wrapper {
  width: 100%;
}

.container-header {
  display: flex;
  justify-content: center;
  align-items: center;
  background-image: url("@/assets/fondo.png");
  background-size: cover;
  background-position: center;
  padding: 15px 20px; /* Un poco de padding lateral */
  border-bottom: 3px solid #000;
}

.logo {
  height: 80px;
  max-width: 100%; /* Evita que el logo se salga en pantallas mini */
  object-fit: contain;
}

.nav-bar {
  display: flex;
  flex-wrap: wrap; /* Permite que los items bajen si no caben */
  justify-content: center;
  gap: 20px; /* Reduje el gap para que quepa mejor en tablets */
  padding: 12px 15px;
  background: #8e0000;
  border-bottom: 3px solid #000;
}

.nav-bar a {
  font-size: 18px; /* Un pelín más pequeño para mejor compatibilidad */
  font-weight: 600;
  color: #ffe031;
  text-decoration: none;
  padding: 5px 10px;
  white-space: nowrap; /* Evita que el texto de un link se rompa en dos líneas */
  transition: all 0.3s ease;
}

.nav-bar a:hover {
  color: #ffffff;
}

.active {
  color: white !important;
  border-bottom: 2px solid #ffe031;
}

/* --- MEDIA QUERIES PARA RESPONSIVE --- */

/* Tablets y Móviles grandes */
@media (max-width: 768px) {
  .logo {
    height: 60px;
  }
  
  .nav-bar {
    gap: 15px;
  }

  .nav-bar a {
    font-size: 16px;
  }
}

/* Móviles pequeños */
@media (max-width: 480px) {
  .container-header {
    padding: 10px 0;
  }

  .logo {
    height: 50px;
  }

  .nav-bar {
    flex-direction: column; /* Los enlaces se apilan verticalmente */
    align-items: center;
    gap: 10px;
    padding: 15px 0;
  }

  .nav-bar a {
    width: 90%; /* Botones más anchos para tocar fácil */
    text-align: center;
    border-bottom: 1px solid rgba(255, 255, 255, 0.1);
  }
  
  .active {
    border-bottom: 2px solid #ffe031;
    background: rgba(255, 255, 255, 0.1);
  }
}
</style>