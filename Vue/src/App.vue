<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
export default {
  name: "App"
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Orbitron:wght@400;600;800&display=swap');

/* FONDO GLOBAL */
body {
  margin: 0;
  min-height: 100vh;
  font-family: 'Orbitron', sans-serif;
  background: radial-gradient(circle at top, #1f1f1f, #0b0b0b);
  color: #ffe031;
}

* {
  box-sizing: border-box;
}
</style>
