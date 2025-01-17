import { Injectable } from "@angular/core";
import { Book } from "../models/book";


@Injectable({
  providedIn:'root'
})

export class BookService {
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
  getBooks(): Book[]{
    return [...this.books];
  }
}
