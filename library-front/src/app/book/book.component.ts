import { Book } from './../models/book';
import { Component, Input, OnInit } from '@angular/core';
@Component({
  selector: 'app-book',
  standalone: true,
  imports: [],
  templateUrl: './book.component.html',
  styleUrl: './book.component.scss'
})
export class BookComponent implements OnInit {
  @Input({required:true}) book!: Book;
  // @input : le parent qui le fourni a lenfant . Il peut l utiliser mais si l enfant effectue des changement
  // le parents le saura

   // constructor(private bookService: BookService) {}
    //books$!: Observable <BookComponent[]>;

  ngOnInit(): void {
  //this.books$ = this.bookService.getAllBooks();

  }

}
