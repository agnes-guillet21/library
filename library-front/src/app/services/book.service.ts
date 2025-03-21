import { BookConstants } from './../constants/bookConstants';
import { Injectable } from "@angular/core";
import { Book } from "../models/book";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";



@Injectable({
  providedIn:'root'
})

export class BookService {

  constructor(private http : HttpClient){}

  public getBooks(): Observable<Book[]>{
    return this.http.get<Book[]>(BookConstants.getBooksApiEndpoint);
  }

  public getBookById(bookId : number): Observable<Book> {
    return this.http.get<Book>(`${BookConstants.getBooksApiEndpoint}/${bookId}`);
  }

  public createBook(datas: Book){
    this.http.post(BookConstants.getBooksApiEndpoint, datas)
      .subscribe();// ds le susb traiter l erreur
  }

   public updateBook(datas: Book){
    this.http.put(BookConstants.getBooksApiEndpoint, datas)
    .subscribe();
   }



// TODO  si la suppression ne se fait pas afficher un message utilisateur
   public deleteBook(bookId : number) : Promise<void> {
    const promise = new Promise<void>((resolve) =>{
      this.http.delete<void>(`${BookConstants.getBooksApiEndpoint}/${bookId}`, {
        headers : {
      'Content-Type':'application/json,charset=utf-8'
        }
      })
      .subscribe({
        complete() {
          resolve();
        }
      });
    });
    return promise;
   }

}
