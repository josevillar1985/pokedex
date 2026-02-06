<template>
  <div class="inicio-pokedex">
    <form @submit.prevent="iniciarSesion">
      <h1>Bienvenido a la Pokédex</h1>

      <label>Email</label>
      <input type="email" v-model="usuario.email" placeholder="entrenador@pokedex.com" />

      <label>Contraseña</label>
      <input type="password" v-model="usuario.password" placeholder="••••••••" />

      <button to="">Iniciar sesión</button>

      <p class="registro-link">
        ¿No estás registrado?
        <span @click="$router.push('/registro')">
          Regístrate aquí
        </span>
      </p>
    </form>
  </div>
</template>

<script>
import axios from "axios";
import Swal from "sweetalert2";

export default {
  name: "InicioUsuario",
  data() {
    return {
      usuario: {
        email: "",
        password: ""
      }
    };
  },
  methods: {
    iniciarSesion() {
      
      if (!this.usuario.email || !this.usuario.password) {
        return Swal.fire({
          icon: "error",
          title: "Campos obligatorios",
          text: "Introduce email y contraseña",
          background: "#1e1e1e",
          color: "#ffffff",
          iconColor: "#ef5350",
          confirmButtonColor: "#ef5350"
          
        });
      }

    
      const emailCodificado = encodeURIComponent(this.usuario.email);

      
      axios
        .get(`http://localhost:8082/usuario/${emailCodificado}`)
        .then(response => {

          const usuarioBackend = response.data;

          
          if (usuarioBackend.password !== this.usuario.password) {
            return Swal.fire({
              icon: "error",
              title: "Credenciales incorrectas",
              text: "Email o contraseña incorrectos",
              background: "#1e1e1e",
              color: "#ffffff",
              iconColor: "#ef5350",
              confirmButtonColor: "#ef5350"
            });
          }

          
          Swal.fire({
            icon: "success",
            title: "¡Bienvenido!",
            text: "Accediendo a la Pokédex...",
            background: "#1e1e1e",
            color: "#ffffff",
            iconColor: "#4caf50",
            timer: 1500,
            showConfirmButton: false
          });

          this.$router.push("/home");
        })
        .catch(() => {
          
          Swal.fire({
            icon: "error",
            title: "Usuario no encontrado",
            text: "No existe ninguna cuenta con ese email",
            background: "#1e1e1e",
            color: "#ffffff",
            iconColor: "#ef5350",
            confirmButtonColor: "#ef5350"
          });
        });
    }
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Orbitron:wght@400;600;800&family=Roboto:wght@300;400;500&display=swap');

.inicio-pokedex {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  font-family: 'Roboto', sans-serif;
}

.inicio-pokedex form {
  background: linear-gradient(135deg, #c62828, #8e0000);
  border: 4px solid #000;
  border-radius: 16px;
  padding: 32px 36px;
  width: 420px;
  box-shadow: 0 14px 28px rgba(0, 0, 0, 0.75);
}

.inicio-pokedex h1 {
  font-family: 'Orbitron', sans-serif;
  font-weight: 800;
  color: #ffeb3b;
  text-align: center;
  margin-bottom: 26px;
  letter-spacing: 1px;
  text-shadow: 2px 2px 0 #000;
}

.inicio-pokedex label {
  display: block;
  margin-top: 14px;
  margin-bottom: 6px;
  color: #ffffff;
  font-weight: 500;
  font-size: 14px;
  text-shadow: 1px 1px 0 #000;
}

.inicio-pokedex input {
  width: 100%;
  padding: 10px 12px;
  border-radius: 8px;
  border: 2px solid #000;
  background-color: #f5f5f5;
  font-size: 14px;
}

.inicio-pokedex input:focus {
  outline: none;
  border-color: #ffeb3b;
  background-color: #ffffff;
}

.inicio-pokedex button {
  width: 100%;
  margin-top: 26px;
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

.inicio-pokedex button:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 14px rgba(0, 0, 0, 0.6);
}

.registro-link {
  margin-top: 18px;
  text-align: center;
  color: #ffffff;
  font-size: 13px;
}

.registro-link span {
  color: #ffeb3b;
  cursor: pointer;
  font-weight: 600;
  margin-left: 4px;
}

.registro-link span:hover {
  text-decoration: underline;
}
</style>
