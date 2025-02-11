import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Book } from './models/book';
import { HeaderComponent } from './home-component/header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { FooterComponent } from './home-component/footer/footer.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    HeaderComponent,
    RouterOutlet,
    HttpClientModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {

  books!: Book[];

  ngOnInit(): void {

  }
}

