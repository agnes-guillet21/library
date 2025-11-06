<script setup lang="ts">

    import { ref, onMounted } from 'vue';
    import Button from '@/components/Button.vue';
    import Link from '@/components/Link.vue';
    import BookRequestService from '@/Services/bookRequestService';


    const bookRequestService = new BookRequestService();
    const books = ref<BookModel[]>([]);

    onMounted(async () => {
      try {
        books.value = await bookRequestService.getLastBooks();
      } catch (error) {
        console.error(error);
      }    
    });


</script>

<template>
    <section class="welcome-section">
        <div class="welcome-content">
            <h1>Bienvenue dans votre bibliothèque en ligne</h1>
            <p> Explorez notre collection de livres, découvrez de nouveaux auteurs et empruntez facilement vos ouvrages favoris.
            Cet espace est conçu pour que se soit simple et agréable. <br> Consultez les titres disponibles, suivez vos prêts en cours et gérez votre compte en toute autonomie.</p>
            <p>Plongez dans la lecture, nous nous occupons du reste.</p>
            <Link to="liste/livres" label="Découvrir tous les livres"/> 
        </div>
    </section>

    <div class="books-container"> 
        <h2>Derniers livres ajoutés</h2>
        <Link to="liste/livres" label="Tous les livres"> </Link>  <!-- TODO Renvoie a la page de liste des livres -->
        
        <div v-if="books.length === 0">
            <p>Aucun livre trouvé.</p>
        </div>
        <div class="books-grid">
            <div class="book-card" v-for="book in books" :key="book.id">
                <img v-if="book.image":src="book.image" alt="Couverture du livre" class="book-image"/>
                <div class="book-content">    
                    <h3 class="book-title">{{ book.title }}</h3>
                    <p class="book-description">{{ book.description }}</p>
                    <p class="book-author">
                        Auteur: {{ (book.authorFirstName || book.authorLastName) ? `${book.authorFirstName || ''} ${book.authorLastName || ''}`: 'Inconnu' }}
                    </p>
                    <p> Livre ajouté le {{ book.addDate }}</p>
                </div>
                <div class="book-footer">
                    <Button class="book-button"label ="Voir plus" /> <!-- TODO  faire appel a un component generique Button + props-->
                </div>
            </div>
        </div>
    </div>
</template>

<style>
    .welcome-section {
        background: var(--color-bg);
        display: flex;
    
        align-items: center;
        padding: 4rem 2rem;
        font-family: var(--font-main);
    }

    .welcome-content p {
        color: var(--color-dark);
        font-size: 1.05rem;
        line-height: 1.7;
        margin-bottom: 1rem;
        opacity: 0.9;
    }

    .welcome-content h1 {
         color: var(--color-primary);
        font-size: 2.4rem;
        font-weight: 600;
        margin-bottom: 1.5rem;
        letter-spacing: 0.5px;
    }

    .welcome-content p {
        font-size: 1.05rem;
        line-height: 1.7;
        margin-bottom: 1rem;
        color: var(--color-secondary);
    }

    .welcome-button {
        display: inline-block;
        background: var(--color-primary);
        color: var(--color-bg);
        padding: 0.9rem 2rem;
        border-radius: 50px;
        text-decoration: none;
        font-weight: 500;
        font-size: 1rem;
        letter-spacing: 0.3px;
        transition: all 0.3s ease;
        box-shadow: 0 4px 10px rgba(52, 101, 109, 0.25);
    }

    .welcome-button:hover {
         background: var(--color-dark);
        transform: translateY(-2px);
        box-shadow: 0 6px 14px rgba(51, 68, 67, 0.3);
    }
</style>