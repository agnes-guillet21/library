import Book from '@/pages/Book/Book.vue'
import BookList from '@/pages/Book/BookList.vue'
import Home from '@/pages/Home.vue'
import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/liste/livres',
      name: 'List Book Page',
      component: BookList,
    },
    {
      path: '/livre/detail',
      name: 'Detail Book Page',
      component: Book,
      props: true
    },
  ],
})

export default router
