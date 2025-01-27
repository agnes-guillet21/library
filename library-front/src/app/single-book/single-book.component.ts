import { Book } from '../models/book';
import { Component, inject, Input, OnInit } from '@angular/core';
import { BookService } from '../services/book.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-single-book',
  standalone: true,
  imports: [],
  templateUrl: './single-book.component.html',
  styleUrl: './single-book.component.scss'
})
export class SingleBookComponent implements OnInit {
  private router = inject(Router);
  private bookService = inject(BookService);
  private route = inject(ActivatedRoute);

 book!: Book;

    //books$!: Observable <BookComponent[]>;

  ngOnInit(): void {
      //this.getBook();

  //this.books$ = this.bookService.getAllBooks();
    }

/*
  private getBook() {
    const bookId = this.route.snapshot.params['id'];
    try {
      this.book = this.bookService.getBookById(bookId);
    } catch (e) {
      this.router.navigate(['/books']);
    }
  }
*/


}
