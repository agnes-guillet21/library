import { Routes } from '@angular/router';
import { BookListComponent } from './book-components/book-list/book-list.component';
import { LandingPageComponent } from './home-component/landing-page/landing-page.component';
import { SingleBookComponent } from './book-components/single-book/single-book.component';
import { BookFormComponent } from './book-components/book-form/book-form.component';

export const routes: Routes = [
  {path:'books/:id',component: SingleBookComponent },
  {path: 'books', component: BookListComponent},
  {path: '', component: LandingPageComponent},
  {path:'create', component: BookFormComponent},
  {path:'update/:id', component: BookFormComponent}
];
