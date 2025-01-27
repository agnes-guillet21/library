import { inject, Injectable } from "@angular/core";
import { Book } from "../models/book";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";


@Injectable({
  providedIn:'root'
})

export class BookService {
constructor(private http : HttpClient){}



  private books: Book[]= [
    new Book(
      "Mon super livre",
      "c'est un super livre",
      "super auteur",
      1
    ),
    new Book(
      "un autre super livre",
      "c'est un autre super livre",
      " un autre super auteur",
      2
    ),
    new Book(
      "Mon super livre",
      "c'est un super livre",
      "un auteur",
      3
    ),

  ];
/*
  getBooks(): Book[]{
    return [...this.books];
  }*/

  getBooks(): Observable<Book[]>{
    return this.http.get<Book[]>('http://localhost:9000/books');
  }


  getBookById(bookId : string): Book {
    const foundBook: Book | undefined = this.books.find((book: Book) => book.id === bookId);
    if (!foundBook){
      throw new Error('Book not find');
    }
    return foundBook;
  }

}
