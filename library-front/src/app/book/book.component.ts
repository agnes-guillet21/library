  import { Router } from '@angular/router';
  import { BookService } from '../services/book.service';
  import { Book } from './../models/book';
  import { Component, inject, Input, OnInit } from '@angular/core';
  @Component({
    selector: 'app-book',
    standalone: true,
    imports: [],
    templateUrl: './book.component.html',
    styleUrl: './book.component.scss'
  })
  export class BookComponent implements OnInit {
    private bookService = inject(BookService);
    private router = inject(Router);
    @Input({required:true}) book!: Book;


      onViewBook(){
        this.router.navigateByUrl(`books/${this.book.id}`)
      }

    ngOnInit(): void {
    }
  }
