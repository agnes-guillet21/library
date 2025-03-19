import { Component, ElementRef, HostListener, inject, OnInit } from '@angular/core';
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
  private bookService : BookService){}

  ngOnInit(): void {

    this.bookId = this.route.snapshot.params['id'];
    this.title = this.titleValue(this.bookId);


    this.bookForm= this.formBuilder.group({
      title:[null, Validators.required],
      description: [null],
      author: [null, Validators.required],
      isbn: [null, Validators.required],
      image: [null],
      imageBase64: [null]
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
    console.log(datasBook);
    if(!!this.bookId){
      datasBook.id = this.bookId;
      this.updateBook(datasBook);
    } else {
      this.createNewBook(datasBook);
    }

  }

  onFileChange(event: Event) {
    const input = event.target as HTMLInputElement;

    if (input.files && input.files.length > 0) {
      const file = input.files[0];  // Récupérer le fichier sélectionné
      this.convertFileToBase64(file).then((base64: string) => {

        this.bookForm.patchValue({ image: base64 }); // Stocker l'image encodée dans le formulaire
      });
    }
  }

  /**
   * Convertit un fichier en Base64
   */
  convertFileToBase64(file: File): Promise<string> {
    return new Promise((resolve, reject) => {
      const reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = () => resolve(reader.result as string); // Convertit en Base64
      reader.onerror = (error) => reject(error);
    });
  }


  private createNewBook(datas: Book): void{
    console.log(datas);
   this.bookService.createBook(datas);
  }
  private updateBook(datas: Book){
    this.bookService.updateBook(datas)}

  private titleValue(bookId: number){
    bookId? this.title = "Modification" : this.title = "Nouveau livre";
    return this.title;
  }

}
