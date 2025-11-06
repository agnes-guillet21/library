import { ref, onMounted } from 'vue';
import axios from 'axios';
import bookModel from '@/Models/Book';

export default class BookRequestService {

  public async getLastBooks(): Promise<BookModel[]> {
    try {
      const response = await axios.get<any[]>('http://localhost:9000/books/last');
      const books = response.data.map((b) => bookModel.convertFromApi(b));
      console.log('Livres récupérés avec succès:', books);
      return books;
    } catch (error) {
      console.error('Erreur lors de la récupération des livres:', error);
      throw error;
    }
  }


  public async getAllBooks(): Promise<bookModel[]> {
    try {
      const response = await axios.get<any[]>('http://localhost:9000/books');
      const books = response.data.map((b) => bookModel.convertFromApi(b));
      console.log('Liste de Livre récupérée avec succès:', books);
      return books;
    } catch(error){
      console.error('Erreur lors de la récupération de la liste de livre:', error);
      throw error;  
    }
  }

  public async getBookById(id: number): Promise<bookModel> {
    try{
      const response = await axios.get<any[]>('http://localhost:9000/books/${id}');
      const books = response.data.map((b) => bookModel.convertFromApi(b));
      console.log('Liste de Livre récupérée avec succès:', books);
      return books;
    } catch(error) {

    }
  }
        
}

