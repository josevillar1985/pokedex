<template>
  <div class="registro-pokedex">
    <form @submit.prevent="registrar">
      <h1>Registro de Entrenador</h1>

      <label>Nombre de entrenador</label>
      <input
        type="text"
        v-model="usuario.nombre"
        placeholder="Ash Ketchum"
      />

      <label>Email</label>
      <input
        type="email"
        v-model="usuario.email"
        placeholder="entrenador@pokedex.com"
      />

      <label>Contraseña</label>
      <input
        type="password"
        v-model="usuario.password"
        placeholder="••••••••"
      />

      <label>Repetir contraseña</label>
      <input
        type="password"
        v-model="usuario.password2"
        placeholder="••••••••"
      />

      <!-- AVATAR / IMAGEN -->
      <label>Avatar (opcional)</label>
      <input
        type="text"
        v-model="usuario.avatar"
        placeholder="URL de tu avatar o Pokémon favorito"
      />

      <button>Crear cuenta</button>

      <p class="login-link">
        ¿Ya tienes cuenta?
        <span @click="$router.push('/')">Inicia sesión</span>
      </p>
    </form>
  </div>
</template>

<script>
import Swal from "sweetalert2";

export default {
  name: "RegistroUsuario",
  data() {
    return {
      usuario: {
        nombre: "",
        email: "",
        password: "",
        password2: "",
        avatar: ""
      }
    };
  },
  methods: {
    registrar() {
      // VALIDACIONES
      if (
        !this.usuario.nombre ||
        !this.usuario.email ||
        !this.usuario.password ||
        !this.usuario.password2
      ) {
        return Swal.fire({
          icon: "error",
          title: "Campos obligatorios",
          text: "Rellena todos los campos",
          background: "#1e1e1e",
          color: "#ffffff",
          iconColor: "#ef5350",
          confirmButtonColor: "#ef5350"
        });
      }

      if (this.usuario.password !== this.usuario.password2) {
        return Swal.fire({
          icon: "error",
          title: "Contraseñas incorrectas",
          text: "Las contraseñas no coinciden",
          background: "#1e1e1e",
          color: "#ffffff",
          iconColor: "#ef5350",
          confirmButtonColor: "#ef5350"
        });
      }

      // 🔒 AQUÍ IRÁ EL AXIOS POST EN EL FUTURO
      // axios.post("/api/usuarios", this.usuario)

      Swal.fire({
        icon: "success",
        title: "¡Registro completado!",
        text: "Ya puedes iniciar sesión",
        background: "#1e1e1e",
        color: "#ffffff",
        iconColor: "#4caf50",
        confirmButtonColor: "#42a5f5"
      });

      this.$router.push("/login");
    }
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Orbitron:wght@400;600;800&family=Roboto:wght@300;400;500&display=swap');

.registro-pokedex {
  display: flex;
  justify-content: center;
  align-items: center;       
  min-height: 100vh;         
  font-family: 'Roboto', sans-serif;
}


.registro-pokedex form {
  background: linear-gradient(135deg, #c62828, #8e0000);
  border: 4px solid #000;
  border-radius: 16px;
  padding: 30px 34px;
  width: 440px;
  box-shadow: 0 12px 26px rgba(0, 0, 0, 0.75);
}

.registro-pokedex h1 {
  font-family: 'Orbitron', sans-serif;
  font-weight: 800;
  color: #ffeb3b;
  text-align: center;
  margin-bottom: 24px;
  letter-spacing: 1px;
  text-shadow: 2px 2px 0 #000;
}

.registro-pokedex label {
  display: block;
  margin-top: 14px;
  margin-bottom: 6px;
  color: #ffffff;
  font-weight: 500;
  font-size: 14px;
  text-shadow: 1px 1px 0 #000;
}

.registro-pokedex input {
  width: 100%;
  padding: 10px 12px;
  border-radius: 8px;
  border: 2px solid #000;
  background-color: #f5f5f5;
  font-size: 14px;
}

.registro-pokedex input:focus {
  outline: none;
  border-color: #ffeb3b;
  background-color: #ffffff;
}

.registro-pokedex button {
  width: 100%;
  margin-top: 24px;
  padding: 12px;
  background: linear-gradient(135deg, #ffeb3b, #fbc02d);
  border: 3px solid #000;
  border-radius: 12px;
  font-family: 'Orbitron', sans-serif;
  font-weight: 700;
  font-size: 15px;
  letter-spacing: 1px;
  cursor: pointer;
  transition: transform 0.15s ease, box-shadow 0.15s ease;
}

.registro-pokedex button:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 14px rgba(0, 0, 0, 0.6);
}

.login-link {
  margin-top: 18px;
  text-align: center;
  color: #fff;
  font-size: 13px;
}

.login-link span {
  color: #ffeb3b;
  cursor: pointer;
  font-weight: 600;
  margin-left: 4px;
}

.login-link span:hover {
  text-decoration: underline;
}
</style>
