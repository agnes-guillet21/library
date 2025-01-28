import { inject, Injectable } from "@angular/core";
import { Book } from "../models/book";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";


@Injectable({
  providedIn:'root'
})

export class BookService {

  constructor(private http : HttpClient){}

  getBooks(): Observable<Book[]>{
    return this.http.get<Book[]>('http://localhost:9000/books');
  }

  getBookById(bookId : number): Observable<Book> {
    return this.http.get<Book>(`http://localhost:9000/books/${bookId}`);
  }

}
