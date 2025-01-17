import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Book } from './models/book';
import { HeaderComponent } from './header/header.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    HeaderComponent,
    RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {

  books!: Book[];

  ngOnInit(): void {

  }
}

