<script lang="ts" setup>

    import { ref, onMounted } from 'vue';
    import axios from 'axios';
    import Link from '@/components/Link.vue';
    import Button from '@/components/Button.vue';

    const items = ref([]);
    const getAllBooks = () => {
      axios.get('http://localhost:9000/books')
        .then(response => {
          console.log('livres récupérés avec succès:', response.data);
          items.value = response.data;
        })
        .catch(error => {
          console.error('Erreur lors de la récupération des livres:', error);
        });
    };

    onMounted(getAllBooks);

</script>


<template>
  <div class="books-container"> 
        <h2>Liste des livres</h2>
        <Link to="/" label="Page d'accueil"> </Link> 
        
        <div v-if="items.length === 0">
            <p>Aucun livre trouvé.</p>
        </div>

        <div  class="books-grid">
            <div class="book-card" v-for="book in items" :key="book.id">
                <img v-if="book.image":src="book.image" alt="Couverture du livre" class="book-image"/>
                <div class="book-content">    
                    <h3 class="book-title">{{ book.title }}</h3>
                    <p class="book-description">{{ book.description }}</p>
                    <p class="book-author">
                        {{ (book.authorFirstName || book.authorLastName) ? `${book.authorFirstName || ''} ${book.authorLastName || ''}`: 'Inconnu' }}
                    </p>
                </div>
                <div class="book-footer">
                    <!-- <Button class="book-button"label ="Detail" :id="book.id"/>  -->
                    <router-link to="`/livre/detail/${book.id}`">Detail</router-link>
                </div>
            </div>
        </div>
    </div>
</template>


 <!-- <style>
.books-container {
        padding: 20px;
        background-color: var(--vt-c-white-softs);
        color: var(--color-text);
        min-height: 100vh;
        font-family: var(--font-base);
    }

    .books-container h2 {
        text-align: start;
        margin-bottom: 30px;
        font-size: 2rem;
        color: var(--color-secondary);
    }

    .books-grid {
        display: flex;
        flex-wrap: wrap;
        margin-left: 30px;
        margin-top: 10px;
        gap: 35px;
    }


    .book-card {
        background: var(--vt-c-white-softd);
        border-radius: var(--radius-md);
        width: 280px;
        display: flex;
        flex-direction: column;
        overflow: hidden;
        box-shadow: 0 10px 30px rgba(16, 24, 40, .08);
        transition: transform var(--transition-fast), box-shadow var(--transition-fast);
        border: 1px solid #eef0f3;
       
    }

    .book-card:hover {
        transform: translateY(-5px);
        box-shadow: 0 6px 16px rgba(51, 68, 67, 0.3);
    }

    .book-image {
        width: 100%;
        height: 180px;
        object-fit: cover;
        border-bottom: 3px solid var(--color-secondary);
    }


    .book-content {
        padding: 15px;
        flex-grow: 1;
    }

    .book-title {
        font-size: 1.2rem;
        margin-bottom: 10px;
        text-transform: capitalize;
        color: var(--color-title);
    }

    .book-description {
        font-size: 0.9rem;
        margin-bottom: 10px;
        color: var(--color-text);

    }

    .book-author {
        font-size: 0.9rem;
        color: var(--color-text);
    }


    .book-footer {
        background: var(--color-secondary);
        padding: 10px;
        text-align: center;
    }

    .book-button {
        background: var(--color-primary);
        color: var(--color-text-light);
        border: none;
        padding: 8px 16px;
        border-radius: var(--radius-md);
        cursor: pointer;
        font-family: var(--font-base);
        font-weight: 600;
        transition: background var(--transition-fast), transform var(--transition-fast);
    }

    .book-button:hover {
        background: var(--color-secondary);
        transform: scale(1.03);
    } 
</style>-->