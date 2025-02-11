import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, NG_ASYNC_VALIDATORS, ReactiveFormsModule, Validators } from '@angular/forms';
import { map, Observable } from 'rxjs';
import { Book } from '../../models/book';
import { BookService } from '../../services/book.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-book-form',
  standalone: true,
  imports: [
   ReactiveFormsModule,
   FormsModule,
  ],
  templateUrl: './book-form.component.html',
  styleUrl: './book-form.component.scss'
})
export class BookFormComponent implements OnInit {
  bookForm!: FormGroup;

  private route = inject(ActivatedRoute);
  private bookId!: number;
  public title! : string;

  newBook$!: Observable<Book>

  constructor(private formBuilder: FormBuilder,
  private bookService : BookService
  ){}


  ngOnInit(): void {

    this.bookId = this.route.snapshot.params['id'];
    this.title = this.titleValue(this.bookId);


    this.bookForm= this.formBuilder.group({
      title:[null, Validators.required],
      description: [null],
      author: [null, Validators.required],
      isbn: [null, Validators.required]
    });
    this.newBook$ = this.bookForm.valueChanges.pipe(
      map(formValue => ({
        ...formValue,
      }))
    );

    /* For put request */
    this.bookService
    .getBookById(this.bookId)
    .subscribe((book : Book)=> {
      this.bookForm.patchValue(book);
    });



  }

  onSubmitForm(): void{
    const datasBook = this.bookForm.value;
    if(!!this.bookId){
      datasBook.id = this.bookId;
      console.log(datasBook);
      this.updateBook(datasBook);
    } else {
      this.createNewBook(datasBook);
    }

  }

  private createNewBook(datas: Book): void{
   this.bookService.createBook(datas);
  }
  private updateBook(datas: Book){
    this.bookService.updateBook(datas)}

  private titleValue(bookId: number){
    bookId? this.title = "Modification" : this.title = "Nouveau livre";
    return this.title;
  }
}
