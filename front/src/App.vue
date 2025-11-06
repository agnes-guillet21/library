<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import  NavBar  from '@/components/NavBar.vue'
</script>

<template>
  <header>
    <NavBar />
  </header>

  <main class="main">
    <RouterView />
  </main>

  <footer>
    
  </footer>
</template>

<style scoped>
</style>
