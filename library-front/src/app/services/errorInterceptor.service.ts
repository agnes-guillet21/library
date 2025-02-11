import { BookService } from './book.service';

import { HttpEvent, HttpHandler, HttpInterceptor, HttpInterceptorFn, HttpRequest, HttpResponse } from "@angular/common/http";
import { Observable, tap } from "rxjs";
import { MessageService } from "./message.service";
import { Injectable } from '@angular/core';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor{

  constructor(private BookService: BookService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log( 'Requête HTTP sortante', request);
      return next.handle(request);
    /*return next. handle(request). pipe (
      tap(
        ( event: HttpEvent< any > ) => {
        console.log ('Réponse HTTP entrante', event);
      }));*/
  }
}
