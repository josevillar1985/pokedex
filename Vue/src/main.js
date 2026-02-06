import Vue from "vue";
import App from "./App.vue";
import VueRouter from "vue-router";
import PokemonList from "./components/PokemonList.vue";
import HomeView from "./components/HomeView.vue";
import FormPokemon from "./components/FormPokemon.vue";
import EditarPoke from "./components/EditarPoke.vue";

Vue.config.productionTip = false;

Vue.use(VueRouter);


const routes = [
  {
    path: "/pokedex",
    component: PokemonList
  },
  {
    path: "/",
    component: HomeView
  },
  {
    path: "/pokemon",
    component: FormPokemon
  },
  {
    path: "/editar",
    component: EditarPoke
  },
  {
    path: "/home",
    component: HomeView
  }
];

// 🔹 router
const router = new VueRouter({
  mode: "history",
  routes
});

// 🔹 app
new Vue({
  router,
  render: h => h(App)
}).$mount("#app");


