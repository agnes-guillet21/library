import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-landing-page',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './landing-page.component.html',
  styleUrl: './landing-page.component.scss'
})
export class LandingPageComponent implements OnInit {

  constructor(private router: Router ){}
  ngOnInit(): void {}

  onContinue(){
    this.router.navigateByUrl('books');
  }

  onAddNewBook(): void{
    this.router.navigateByUrl('/create');

  }

}
