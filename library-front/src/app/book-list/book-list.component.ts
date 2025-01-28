import { Observable } from 'rxjs';
import { BookComponent } from '../book/book.component';
import { Book } from './../models/book';
import { BookService } from './../services/book.service';
import { Component, inject, OnInit } from '@angular/core';
import { AsyncPipe, CommonModule } from '@angular/common';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [
    BookComponent,
    CommonModule,
  ],
  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.scss'
})
export class BookListComponent implements OnInit {
  private bookService = inject(BookService);
  books!: Book[];
  books$! : Observable<Book[]>;


  ngOnInit(): void {
  this.books$ = this.bookService.getBooks();
  }
}
