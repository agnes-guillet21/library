<script setup>
    
</script>

<template>
    <nav class="navBar">
        <router-link to="/">Accueil</router-link>
        <router-link to="/auteur">Auteurs</router-link>
        <router-link to="/liste/livres">Livres</router-link>
    </nav>
</template>

<style>
    .nav {
        display: flex;
        justify-content: center; /* centre les liens */
        align-items: center;
        gap: 3rem; /* espace entre les liens */
        padding: 0.5rem 0;
    }

    .router-link-active {
        font-weight: bold;
        text-decoration: underline;
    }

    .navBar a {
        color: var(--color-text-light);
        text-decoration: none;
        font-weight: 500;
        margin: 0.8rem;
    }
</style>