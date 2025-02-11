
import { Book } from '../../models/book';
import { Component, inject, Input, OnInit } from '@angular/core';
import { BookService } from '../../services/book.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Observable } from 'rxjs';
import { AsyncPipe, CommonModule } from '@angular/common';
@Component({
  selector: 'app-single-book',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink
  ],
  templateUrl: './single-book.component.html',
  styleUrl: './single-book.component.scss'
})
export class SingleBookComponent implements OnInit {
  private router = inject(Router);
  private bookService = inject(BookService);
  private route = inject(ActivatedRoute);

  books$!: Observable<Book>;
  public readonly bookId = +this.route.snapshot.params['id'];


  ngOnInit(): void {

  const bookId = +this.route.snapshot.params['id'];
  this.books$ = this.bookService.getBookById(bookId);

}

  onUpdateBook(): void {
    this.router.navigateByUrl(`/update/${this.bookId}`);
  }

  onDeleteBook(): void {
    this.bookService.deleteBook(this.bookId)
    .finally(() => {
      this.router.navigateByUrl('/books')
    });

  }

}
