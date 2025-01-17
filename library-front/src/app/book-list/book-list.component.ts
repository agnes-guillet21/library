import { BookComponent } from '../book/book.component';
import { Book } from './../models/book';
import { BookService } from './../services/book.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [BookComponent],
  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.scss'
})
export class BookListComponent implements OnInit {
  books!: Book[];

constructor(private bookService: BookService){}

  ngOnInit(): void {
    this.books = this.bookService.getBooks();
  }
}
